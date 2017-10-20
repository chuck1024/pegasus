// Copyright (c) 2017, Xiaomi, Inc.  All rights reserved.
// This source code is licensed under the Apache License Version 2.0, which
// can be found in the LICENSE file in the root directory of this source tree.

/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package dsn.apps;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-10-17")
public class multi_get_request implements org.apache.thrift.TBase<multi_get_request, multi_get_request._Fields>, java.io.Serializable, Cloneable, Comparable<multi_get_request> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("multi_get_request");

  private static final org.apache.thrift.protocol.TField HASH_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("hash_key", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField SORK_KEYS_FIELD_DESC = new org.apache.thrift.protocol.TField("sork_keys", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField MAX_KV_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("max_kv_count", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField MAX_KV_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("max_kv_size", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField NO_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("no_value", org.apache.thrift.protocol.TType.BOOL, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new multi_get_requestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new multi_get_requestTupleSchemeFactory());
  }

  public dsn.base.blob hash_key; // required
  public List<dsn.base.blob> sork_keys; // required
  public int max_kv_count; // required
  public int max_kv_size; // required
  public boolean no_value; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HASH_KEY((short)1, "hash_key"),
    SORK_KEYS((short)2, "sork_keys"),
    MAX_KV_COUNT((short)3, "max_kv_count"),
    MAX_KV_SIZE((short)4, "max_kv_size"),
    NO_VALUE((short)5, "no_value");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // HASH_KEY
          return HASH_KEY;
        case 2: // SORK_KEYS
          return SORK_KEYS;
        case 3: // MAX_KV_COUNT
          return MAX_KV_COUNT;
        case 4: // MAX_KV_SIZE
          return MAX_KV_SIZE;
        case 5: // NO_VALUE
          return NO_VALUE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __MAX_KV_COUNT_ISSET_ID = 0;
  private static final int __MAX_KV_SIZE_ISSET_ID = 1;
  private static final int __NO_VALUE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HASH_KEY, new org.apache.thrift.meta_data.FieldMetaData("hash_key", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, dsn.base.blob.class)));
    tmpMap.put(_Fields.SORK_KEYS, new org.apache.thrift.meta_data.FieldMetaData("sork_keys", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, dsn.base.blob.class))));
    tmpMap.put(_Fields.MAX_KV_COUNT, new org.apache.thrift.meta_data.FieldMetaData("max_kv_count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MAX_KV_SIZE, new org.apache.thrift.meta_data.FieldMetaData("max_kv_size", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NO_VALUE, new org.apache.thrift.meta_data.FieldMetaData("no_value", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(multi_get_request.class, metaDataMap);
  }

  public multi_get_request() {
  }

  public multi_get_request(
    dsn.base.blob hash_key,
    List<dsn.base.blob> sork_keys,
    int max_kv_count,
    int max_kv_size,
    boolean no_value)
  {
    this();
    this.hash_key = hash_key;
    this.sork_keys = sork_keys;
    this.max_kv_count = max_kv_count;
    setMax_kv_countIsSet(true);
    this.max_kv_size = max_kv_size;
    setMax_kv_sizeIsSet(true);
    this.no_value = no_value;
    setNo_valueIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public multi_get_request(multi_get_request other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHash_key()) {
      this.hash_key = new dsn.base.blob(other.hash_key);
    }
    if (other.isSetSork_keys()) {
      List<dsn.base.blob> __this__sork_keys = new ArrayList<dsn.base.blob>(other.sork_keys.size());
      for (dsn.base.blob other_element : other.sork_keys) {
        __this__sork_keys.add(new dsn.base.blob(other_element));
      }
      this.sork_keys = __this__sork_keys;
    }
    this.max_kv_count = other.max_kv_count;
    this.max_kv_size = other.max_kv_size;
    this.no_value = other.no_value;
  }

  public multi_get_request deepCopy() {
    return new multi_get_request(this);
  }

  @Override
  public void clear() {
    this.hash_key = null;
    this.sork_keys = null;
    setMax_kv_countIsSet(false);
    this.max_kv_count = 0;
    setMax_kv_sizeIsSet(false);
    this.max_kv_size = 0;
    setNo_valueIsSet(false);
    this.no_value = false;
  }

  public dsn.base.blob getHash_key() {
    return this.hash_key;
  }

  public multi_get_request setHash_key(dsn.base.blob hash_key) {
    this.hash_key = hash_key;
    return this;
  }

  public void unsetHash_key() {
    this.hash_key = null;
  }

  /** Returns true if field hash_key is set (has been assigned a value) and false otherwise */
  public boolean isSetHash_key() {
    return this.hash_key != null;
  }

  public void setHash_keyIsSet(boolean value) {
    if (!value) {
      this.hash_key = null;
    }
  }

  public int getSork_keysSize() {
    return (this.sork_keys == null) ? 0 : this.sork_keys.size();
  }

  public java.util.Iterator<dsn.base.blob> getSork_keysIterator() {
    return (this.sork_keys == null) ? null : this.sork_keys.iterator();
  }

  public void addToSork_keys(dsn.base.blob elem) {
    if (this.sork_keys == null) {
      this.sork_keys = new ArrayList<dsn.base.blob>();
    }
    this.sork_keys.add(elem);
  }

  public List<dsn.base.blob> getSork_keys() {
    return this.sork_keys;
  }

  public multi_get_request setSork_keys(List<dsn.base.blob> sork_keys) {
    this.sork_keys = sork_keys;
    return this;
  }

  public void unsetSork_keys() {
    this.sork_keys = null;
  }

  /** Returns true if field sork_keys is set (has been assigned a value) and false otherwise */
  public boolean isSetSork_keys() {
    return this.sork_keys != null;
  }

  public void setSork_keysIsSet(boolean value) {
    if (!value) {
      this.sork_keys = null;
    }
  }

  public int getMax_kv_count() {
    return this.max_kv_count;
  }

  public multi_get_request setMax_kv_count(int max_kv_count) {
    this.max_kv_count = max_kv_count;
    setMax_kv_countIsSet(true);
    return this;
  }

  public void unsetMax_kv_count() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAX_KV_COUNT_ISSET_ID);
  }

  /** Returns true if field max_kv_count is set (has been assigned a value) and false otherwise */
  public boolean isSetMax_kv_count() {
    return EncodingUtils.testBit(__isset_bitfield, __MAX_KV_COUNT_ISSET_ID);
  }

  public void setMax_kv_countIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAX_KV_COUNT_ISSET_ID, value);
  }

  public int getMax_kv_size() {
    return this.max_kv_size;
  }

  public multi_get_request setMax_kv_size(int max_kv_size) {
    this.max_kv_size = max_kv_size;
    setMax_kv_sizeIsSet(true);
    return this;
  }

  public void unsetMax_kv_size() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAX_KV_SIZE_ISSET_ID);
  }

  /** Returns true if field max_kv_size is set (has been assigned a value) and false otherwise */
  public boolean isSetMax_kv_size() {
    return EncodingUtils.testBit(__isset_bitfield, __MAX_KV_SIZE_ISSET_ID);
  }

  public void setMax_kv_sizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAX_KV_SIZE_ISSET_ID, value);
  }

  public boolean isNo_value() {
    return this.no_value;
  }

  public multi_get_request setNo_value(boolean no_value) {
    this.no_value = no_value;
    setNo_valueIsSet(true);
    return this;
  }

  public void unsetNo_value() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __NO_VALUE_ISSET_ID);
  }

  /** Returns true if field no_value is set (has been assigned a value) and false otherwise */
  public boolean isSetNo_value() {
    return EncodingUtils.testBit(__isset_bitfield, __NO_VALUE_ISSET_ID);
  }

  public void setNo_valueIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __NO_VALUE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case HASH_KEY:
      if (value == null) {
        unsetHash_key();
      } else {
        setHash_key((dsn.base.blob)value);
      }
      break;

    case SORK_KEYS:
      if (value == null) {
        unsetSork_keys();
      } else {
        setSork_keys((List<dsn.base.blob>)value);
      }
      break;

    case MAX_KV_COUNT:
      if (value == null) {
        unsetMax_kv_count();
      } else {
        setMax_kv_count((Integer)value);
      }
      break;

    case MAX_KV_SIZE:
      if (value == null) {
        unsetMax_kv_size();
      } else {
        setMax_kv_size((Integer)value);
      }
      break;

    case NO_VALUE:
      if (value == null) {
        unsetNo_value();
      } else {
        setNo_value((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HASH_KEY:
      return getHash_key();

    case SORK_KEYS:
      return getSork_keys();

    case MAX_KV_COUNT:
      return getMax_kv_count();

    case MAX_KV_SIZE:
      return getMax_kv_size();

    case NO_VALUE:
      return isNo_value();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case HASH_KEY:
      return isSetHash_key();
    case SORK_KEYS:
      return isSetSork_keys();
    case MAX_KV_COUNT:
      return isSetMax_kv_count();
    case MAX_KV_SIZE:
      return isSetMax_kv_size();
    case NO_VALUE:
      return isSetNo_value();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof multi_get_request)
      return this.equals((multi_get_request)that);
    return false;
  }

  public boolean equals(multi_get_request that) {
    if (that == null)
      return false;

    boolean this_present_hash_key = true && this.isSetHash_key();
    boolean that_present_hash_key = true && that.isSetHash_key();
    if (this_present_hash_key || that_present_hash_key) {
      if (!(this_present_hash_key && that_present_hash_key))
        return false;
      if (!this.hash_key.equals(that.hash_key))
        return false;
    }

    boolean this_present_sork_keys = true && this.isSetSork_keys();
    boolean that_present_sork_keys = true && that.isSetSork_keys();
    if (this_present_sork_keys || that_present_sork_keys) {
      if (!(this_present_sork_keys && that_present_sork_keys))
        return false;
      if (!this.sork_keys.equals(that.sork_keys))
        return false;
    }

    boolean this_present_max_kv_count = true;
    boolean that_present_max_kv_count = true;
    if (this_present_max_kv_count || that_present_max_kv_count) {
      if (!(this_present_max_kv_count && that_present_max_kv_count))
        return false;
      if (this.max_kv_count != that.max_kv_count)
        return false;
    }

    boolean this_present_max_kv_size = true;
    boolean that_present_max_kv_size = true;
    if (this_present_max_kv_size || that_present_max_kv_size) {
      if (!(this_present_max_kv_size && that_present_max_kv_size))
        return false;
      if (this.max_kv_size != that.max_kv_size)
        return false;
    }

    boolean this_present_no_value = true;
    boolean that_present_no_value = true;
    if (this_present_no_value || that_present_no_value) {
      if (!(this_present_no_value && that_present_no_value))
        return false;
      if (this.no_value != that.no_value)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_hash_key = true && (isSetHash_key());
    list.add(present_hash_key);
    if (present_hash_key)
      list.add(hash_key);

    boolean present_sork_keys = true && (isSetSork_keys());
    list.add(present_sork_keys);
    if (present_sork_keys)
      list.add(sork_keys);

    boolean present_max_kv_count = true;
    list.add(present_max_kv_count);
    if (present_max_kv_count)
      list.add(max_kv_count);

    boolean present_max_kv_size = true;
    list.add(present_max_kv_size);
    if (present_max_kv_size)
      list.add(max_kv_size);

    boolean present_no_value = true;
    list.add(present_no_value);
    if (present_no_value)
      list.add(no_value);

    return list.hashCode();
  }

  @Override
  public int compareTo(multi_get_request other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetHash_key()).compareTo(other.isSetHash_key());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHash_key()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hash_key, other.hash_key);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSork_keys()).compareTo(other.isSetSork_keys());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSork_keys()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sork_keys, other.sork_keys);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMax_kv_count()).compareTo(other.isSetMax_kv_count());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMax_kv_count()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max_kv_count, other.max_kv_count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMax_kv_size()).compareTo(other.isSetMax_kv_size());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMax_kv_size()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.max_kv_size, other.max_kv_size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNo_value()).compareTo(other.isSetNo_value());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNo_value()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.no_value, other.no_value);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("multi_get_request(");
    boolean first = true;

    sb.append("hash_key:");
    if (this.hash_key == null) {
      sb.append("null");
    } else {
      sb.append(this.hash_key);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sork_keys:");
    if (this.sork_keys == null) {
      sb.append("null");
    } else {
      sb.append(this.sork_keys);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("max_kv_count:");
    sb.append(this.max_kv_count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("max_kv_size:");
    sb.append(this.max_kv_size);
    first = false;
    if (!first) sb.append(", ");
    sb.append("no_value:");
    sb.append(this.no_value);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (hash_key != null) {
      hash_key.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class multi_get_requestStandardSchemeFactory implements SchemeFactory {
    public multi_get_requestStandardScheme getScheme() {
      return new multi_get_requestStandardScheme();
    }
  }

  private static class multi_get_requestStandardScheme extends StandardScheme<multi_get_request> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, multi_get_request struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // HASH_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.hash_key = new dsn.base.blob();
              struct.hash_key.read(iprot);
              struct.setHash_keyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SORK_KEYS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.sork_keys = new ArrayList<dsn.base.blob>(_list16.size);
                dsn.base.blob _elem17;
                for (int _i18 = 0; _i18 < _list16.size; ++_i18)
                {
                  _elem17 = new dsn.base.blob();
                  _elem17.read(iprot);
                  struct.sork_keys.add(_elem17);
                }
                iprot.readListEnd();
              }
              struct.setSork_keysIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MAX_KV_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.max_kv_count = iprot.readI32();
              struct.setMax_kv_countIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MAX_KV_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.max_kv_size = iprot.readI32();
              struct.setMax_kv_sizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // NO_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.no_value = iprot.readBool();
              struct.setNo_valueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, multi_get_request struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.hash_key != null) {
        oprot.writeFieldBegin(HASH_KEY_FIELD_DESC);
        struct.hash_key.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.sork_keys != null) {
        oprot.writeFieldBegin(SORK_KEYS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.sork_keys.size()));
          for (dsn.base.blob _iter19 : struct.sork_keys)
          {
            _iter19.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(MAX_KV_COUNT_FIELD_DESC);
      oprot.writeI32(struct.max_kv_count);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MAX_KV_SIZE_FIELD_DESC);
      oprot.writeI32(struct.max_kv_size);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(NO_VALUE_FIELD_DESC);
      oprot.writeBool(struct.no_value);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class multi_get_requestTupleSchemeFactory implements SchemeFactory {
    public multi_get_requestTupleScheme getScheme() {
      return new multi_get_requestTupleScheme();
    }
  }

  private static class multi_get_requestTupleScheme extends TupleScheme<multi_get_request> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, multi_get_request struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHash_key()) {
        optionals.set(0);
      }
      if (struct.isSetSork_keys()) {
        optionals.set(1);
      }
      if (struct.isSetMax_kv_count()) {
        optionals.set(2);
      }
      if (struct.isSetMax_kv_size()) {
        optionals.set(3);
      }
      if (struct.isSetNo_value()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetHash_key()) {
        struct.hash_key.write(oprot);
      }
      if (struct.isSetSork_keys()) {
        {
          oprot.writeI32(struct.sork_keys.size());
          for (dsn.base.blob _iter20 : struct.sork_keys)
          {
            _iter20.write(oprot);
          }
        }
      }
      if (struct.isSetMax_kv_count()) {
        oprot.writeI32(struct.max_kv_count);
      }
      if (struct.isSetMax_kv_size()) {
        oprot.writeI32(struct.max_kv_size);
      }
      if (struct.isSetNo_value()) {
        oprot.writeBool(struct.no_value);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, multi_get_request struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.hash_key = new dsn.base.blob();
        struct.hash_key.read(iprot);
        struct.setHash_keyIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.sork_keys = new ArrayList<dsn.base.blob>(_list21.size);
          dsn.base.blob _elem22;
          for (int _i23 = 0; _i23 < _list21.size; ++_i23)
          {
            _elem22 = new dsn.base.blob();
            _elem22.read(iprot);
            struct.sork_keys.add(_elem22);
          }
        }
        struct.setSork_keysIsSet(true);
      }
      if (incoming.get(2)) {
        struct.max_kv_count = iprot.readI32();
        struct.setMax_kv_countIsSet(true);
      }
      if (incoming.get(3)) {
        struct.max_kv_size = iprot.readI32();
        struct.setMax_kv_sizeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.no_value = iprot.readBool();
        struct.setNo_valueIsSet(true);
      }
    }
  }

}

