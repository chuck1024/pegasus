// Copyright (c) 2017, Xiaomi, Inc.  All rights reserved.
// This source code is licensed under the Apache License Version 2.0, which
// can be found in the LICENSE file in the root directory of this source tree.

package com.xiaomi.infra.pegasus.client;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestScan {
    static char[] CCH = "_0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] buffer = new char[256];
    static Random random;
    
    private static PegasusClientInterface client;
    private static String tableName = "temp";
    
    private static TreeMap<String, TreeMap<String, String>> base;
    private static String expectedHashKey;
  
    @BeforeClass
    public static void setupTestCase() throws PException {
        client = PegasusClientFactory.getSingletonClient();
        random = new Random();
        base = new TreeMap<String, TreeMap<String, String>>();
        expectedHashKey = randomString();
        
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = CCH[random.nextInt(CCH.length)];
        }

        clearDatabase();

        TreeMap<String, String> hashMap = new TreeMap<String, String>();
        for (int i = 0; i < 1000 || hashMap.size() < 1000; i++) {
            String sortKey = randomString();
            String value = randomString();

            client.set(tableName, expectedHashKey.getBytes(), sortKey.getBytes(),
                value.getBytes(), 0);
            hashMap.put(sortKey, value);
        }
        base.put(expectedHashKey, hashMap);

        for (int i = 0; i < 1000 || base.size() < 1000; i++)
        {
            String hashKey = randomString();
            TreeMap<String, String> sortMap = base.get(hashKey);
            if (sortMap == null) {
                sortMap = new TreeMap<String, String>();
                base.put(hashKey, sortMap);
            }
            for (int j = 0; j < 10 || sortMap.size() < 10; j++) {
                String sortKey = randomString();
                String value = randomString();
                client.set(tableName, hashKey.getBytes(), sortKey.getBytes(), value.getBytes(), 0);
                sortMap.put(sortKey, value);
            }
        }
    }

    @Test
    public void testAllSortKey() throws PException {
        /****  ALL SORT_KEYS  ****/
        System.out.println("TESTING_HASH_SCAN, ALL SORT_KEYS ....");
        ScanOptions options = new ScanOptions();
        TreeMap<String, String> data = new TreeMap<String, String>();
        PegasusScannerInterface scanner =
            client.getScanner(tableName, expectedHashKey.getBytes(), new byte[]{}, new byte[]{}, options);
        Assert.assertNotNull(scanner);
        Pair<Pair<byte[], byte[]>, byte[]> item;
        while((item = scanner.next()) != null) {
            Assert.assertEquals(expectedHashKey, new String(item.getLeft().getLeft()));
            checkAndPutSortMap(data, expectedHashKey,
                new String(item.getLeft().getRight()), new String(item.getRight()));
        }
        scanner.close();
        compareSortMap(data, base.get(expectedHashKey), expectedHashKey);
    }

    @Test
    public void testInclusive() throws PException {
        /**** [start, stop]  ****/
        System.out.println("TESTING_HASH_SCAN, [start, stop]...");
        Iterator<String> iterator = base.get(expectedHashKey).keySet().iterator();
        for (int i = random.nextInt(500); i >= 0; i--)
            iterator.next();
        String start = iterator.next();
        for (int i = random.nextInt(400) + 50; i >= 0; i--)
            iterator.next();
        String stop = iterator.next();

        ScanOptions options = new ScanOptions();
        options.startInclusive = true;
        options.stopInclusive = true;
        TreeMap<String, String> data = new TreeMap<String, String>();
        PegasusScannerInterface scanner = client.getScanner(tableName,
            expectedHashKey.getBytes(), start.getBytes(), stop.getBytes(), options);
        Assert.assertNotNull(scanner);
        Pair<Pair<byte[], byte[]>, byte[]> item;
        while((item = scanner.next()) != null) {
            Assert.assertEquals(expectedHashKey, new String(item.getLeft().getLeft()));
            checkAndPutSortMap(data, expectedHashKey,
                new String(item.getLeft().getRight()), new String(item.getRight()));
        }
        scanner.close();
        compareSortMap(data,
            base.get(expectedHashKey).subMap(start, true, stop, true),
            expectedHashKey);
    }

    @Test
    public void testExclusive() throws PException {
        /**** (start, stop) ****/
        System.out.println("TESTING_HASH_SCAN, (start, stop)...");
        Iterator<String> iterator = base.get(expectedHashKey).keySet().iterator();
        for (int i = random.nextInt(500); i >= 0; i--)
            iterator.next();
        String start = iterator.next();
        for (int i = random.nextInt(400) + 50; i >= 0; i--)
            iterator.next();
        String stop = iterator.next();

        ScanOptions options = new ScanOptions();
        options.startInclusive = false;
        options.stopInclusive = false;
        TreeMap<String, String> data = new TreeMap<String, String>();
        PegasusScannerInterface scanner = client.getScanner(tableName,
            expectedHashKey.getBytes(), start.getBytes(), stop.getBytes(), options);
        Assert.assertNotNull(scanner);
        Pair<Pair<byte[], byte[]>, byte[]> item;
        while((item = scanner.next()) != null) {
            Assert.assertEquals(expectedHashKey, new String(item.getLeft().getLeft()));
            checkAndPutSortMap(data, expectedHashKey,
                new String(item.getLeft().getRight()), new String(item.getRight()));
        }
        scanner.close();
        compareSortMap(data,
            base.get(expectedHashKey).subMap(start, false, stop, false),
            expectedHashKey);
    }

    @Test
    public void testOnePoint() throws PException {
        System.out.println("TESTING_HASH_SCAN, [start, start]");
        Iterator<String> iterator = base.get(expectedHashKey).keySet().iterator();
        for (int i = random.nextInt(800); i >= 0; i--)
            iterator.next();
        String start = iterator.next();

        ScanOptions options = new ScanOptions();
        options.startInclusive = true;
        options.stopInclusive = true;
        PegasusScannerInterface scanner = client.getScanner(tableName,
            expectedHashKey.getBytes(), start.getBytes(), start.getBytes(), options);
        Assert.assertNotNull(scanner);
        Pair<Pair<byte[], byte[]>, byte[]> item = scanner.next();
        Assert.assertEquals(start, new String(item.getLeft().getRight()));
        item = scanner.next();
        Assert.assertNull(item);
        scanner.close();
    }

    @Test
    public void testHalfInclusive() throws PException {
        System.out.println("TESTING_HASH_SCAN, [start, start)");
        Iterator<String> iterator = base.get(expectedHashKey).keySet().iterator();
        for (int i = random.nextInt(800); i >= 0; i--)
            iterator.next();
        String start = iterator.next();

        ScanOptions options = new ScanOptions();
        options.startInclusive = true;
        options.stopInclusive = false;
        PegasusScannerInterface scanner = client.getScanner(tableName,
            expectedHashKey.getBytes(), start.getBytes(), start.getBytes(), options);
        Assert.assertNotNull(scanner);
        Pair<Pair<byte[], byte[]>, byte[]> item = scanner.next();
        Assert.assertNull(item);
        scanner.close();
    }

    @Test
    public void testVoidSpan() throws PException {
        /**** [stop, start]  ****/
        System.out.println("TESTING_HASH_SCAN, [stop, start]...");
        Iterator<String> iterator = base.get(expectedHashKey).keySet().iterator();
        for (int i = random.nextInt(500); i >= 0; i--)
            iterator.next();
        String start = iterator.next();
        for (int i = random.nextInt(400) + 50; i >= 0; i--)
            iterator.next();
        String stop = iterator.next();

        ScanOptions options = new ScanOptions();
        options.startInclusive = true;
        options.stopInclusive = true;
        PegasusScannerInterface scanner = client.getScanner(tableName,
            expectedHashKey.getBytes(), stop.getBytes(), start.getBytes(), options);
        Assert.assertNotNull(scanner);
        Pair<Pair<byte[], byte[]>, byte[]> item = scanner.next();
        Assert.assertNull(item);
        scanner.close();
    }

    @Test
    public void testOverallScan() throws PException {
        System.out.println("TEST OVERALL_SCAN...");

        ScanOptions options = new ScanOptions();
        TreeMap<String, TreeMap<String, String>> data = new TreeMap<String, TreeMap<String, String>>();
        List<PegasusScannerInterface> scanners = client.getUnorderedScanners(tableName, 3, options);
        Assert.assertTrue(scanners.size() <= 3);

        for (int i = scanners.size() - 1; i >= 0; i--)
        {
            PegasusScannerInterface scanner = scanners.get(i);
            Assert.assertNotNull(scanner);
            Pair<Pair<byte[], byte[]>, byte[]> item;
            while((item = scanner.next()) != null) {
                checkAndPut(data, new String(item.getLeft().getLeft()), new String(item.getLeft().getRight()),
                    new String(item.getRight()));
            }
            scanner.close();
        }
        compare(data, base);
    }

    private static void clearDatabase() throws PException {
        ScanOptions options = new ScanOptions();
        List<PegasusScannerInterface> scanners = client.getUnorderedScanners(tableName, 1, options);
        Assert.assertEquals(1, scanners.size());
        Assert.assertNotNull(scanners.get(0));

        Pair<Pair<byte[], byte[]>, byte[]> item;
        while((item = scanners.get(0).next()) != null ) {
            client.del(tableName, item.getLeft().getLeft(), item.getLeft().getRight());
        }
        scanners.get(0).close();

        scanners = client.getUnorderedScanners(tableName, 1, options);
        Assert.assertEquals(1, scanners.size());
        Assert.assertNotNull(scanners.get(0));
        item = scanners.get(0).next();
        scanners.get(0).close();
        Assert.assertNull(
            item == null ? null : String.format("Database is cleared but not empty, hashKey=%s, sortKey=%s",
                new String(item.getLeft().getLeft()), new String(item.getLeft().getRight())),
            item);
    }

    private static String randomString() {
      int pos = random.nextInt(buffer.length);
      buffer[pos] = CCH[random.nextInt(CCH.length)];
      int length = random.nextInt(buffer.length) + 1;
      if (pos + length < buffer.length) {
        return new String(buffer, pos, length);
      } else {
        return new String(buffer, pos, buffer.length - pos) + 
            new String(buffer, 0, length + pos - buffer.length);
      }
    }
  
    private static void checkAndPut(TreeMap<String, TreeMap<String, String>> data,
            String hashKey, String sortKey, String value) {
        TreeMap<String, String> sortMap = data.get(hashKey);
        if (sortMap == null) {
            sortMap = new TreeMap<String, String>();
            data.put(hashKey, sortMap);
        } else {
            Assert.assertNull(
                String.format("Duplicate: hashKey=%s, sortKye=%s, oldValue=%s, newValue=%s",
                    hashKey, sortKey, sortMap.get(sortKey), value),
                sortMap.get(sortKey));
        }
        sortMap.put(sortKey, value);
    }
  
    private static void checkAndPutSortMap(TreeMap<String, String> data,
            String hashKey, String sortKey, String value) {
      Assert.assertNull(
          String.format("Duplicate: hashKey=%s, sortKye=%s, oldValue=%s, newValue=%s",
              hashKey, sortKey, data.get(sortKey), value),
          data.get(sortKey));
      data.put(sortKey, value);
    }
  
    private static void compare(TreeMap<String, TreeMap<String, String>> data,
            TreeMap<String, TreeMap<String, String>> base) {
        Iterator<Map.Entry<String, TreeMap<String, String>>> iterator1 = data.entrySet().iterator();
        Iterator<Map.Entry<String, TreeMap<String, String>>> iterator2 = base.entrySet().iterator();
        while(true) {
            Map.Entry<String, TreeMap<String, String>> kv1 = 
                iterator1.hasNext() ? iterator1.next() : null;
            Map.Entry<String, TreeMap<String, String>> kv2 =
                iterator2.hasNext() ? iterator2.next() : null;
            if (kv1 == null) {
                Assert.assertNull(
                    kv2 == null ? null : String.format("Only in base: hashKey=%s", kv2.getKey()),
                    kv2);  
                break;
            }
            Assert.assertNotNull(String.format("Only in data: hashKey=%s", kv1.getKey()),
                kv2);
            Assert.assertEquals(
                String.format("Diff: dataHashKey=%s, baseHashKey=%s", kv1.getKey(), kv2.getKey()),
                kv1.getKey(), kv2.getKey());
            Iterator<Map.Entry<String, String>> iterator3 = kv1.getValue().entrySet().iterator();
            Iterator<Map.Entry<String, String>> iterator4 = kv2.getValue().entrySet().iterator();
            while(true) {
                Map.Entry<String, String> kv3 = iterator3.hasNext() ? iterator3.next() : null;
                Map.Entry<String, String> kv4 = iterator4.hasNext() ? iterator4.next() : null;
                if (kv3 == null) {
                    Assert.assertNull(
                        kv4 == null ? null : String.format("Only in base: hashKey=%s, sortKey=%s, value=%s",
                            kv1.getKey(), kv4.getKey(), kv4.getValue()),
                        kv4);
                    break;
                }
                Assert.assertNotNull(
                    String.format("Only in data: hashKey=%s, sortKey=%s, value=%s",
                        kv1.getKey(), kv3.getKey(), kv3.getValue()),
                    kv4);
                Assert.assertEquals(
                    String.format("Diff: hashKey=%s, dataSortKey=%s, dataValue=%s, baseSortKey=%s, baseValue=%s",
                      kv1.getKey(), kv3.getKey(), kv3.getValue(), kv4.getKey(), kv4.getValue()),
                    kv3, kv4);
            }
        }
    }
  
    private static void compareSortMap(NavigableMap<String, String> data, NavigableMap<String, String> base, 
            String hashKey) {
        Iterator<Map.Entry<String, String>> iterator1 = data.entrySet().iterator();
        Iterator<Map.Entry<String, String>> iterator2 = base.entrySet().iterator();
        while(true) {
            Map.Entry<String, String> kv1 = iterator1.hasNext() ? iterator1.next() : null;
            Map.Entry<String, String> kv2 = iterator2.hasNext() ? iterator2.next() : null;
            if (kv1 == null) {
                Assert.assertNull(
                    kv2 == null ? null : String.format("Only in base: hashKey=%s, sortKey=%s, value=%s",
                        hashKey, kv2.getKey(), kv2.getValue()),
                    kv2);
                break;
            }
            Assert.assertNotNull( String.format("Only in data: hashKey=%s, sortKey=%s, value=%s",
                    hashKey, kv1.getKey(), kv1.getValue()),
                kv2);
            Assert.assertEquals(
                String.format("Diff: hashKey=%s, dataSortKey=%s, dataValue=%s, baseSortKey=%s, baseValue=%s",
                    hashKey, kv1.getKey(), kv1.getValue(), kv2.getKey(), kv2.getValue()),
                kv1, kv2);
        }
    }
}
