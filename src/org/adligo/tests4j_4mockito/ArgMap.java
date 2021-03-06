package org.adligo.tests4j_4mockito;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ArgMap<T> implements Map<ObjParams, T>{
  public static final String OBJECT_ARRAY_CLASS_NAME = new Object[] {}.getClass().getName();
  
  private final Map<ObjParams, T> delegate_ = new HashMap<ObjParams, T>();
  private final T defaultValue_;
  private final I_ArgFactory<T> factory_;
  
  public ArgMap() {
    defaultValue_ = null;
    factory_ = null;
  };
  
  public ArgMap(T defaultValue) {
    defaultValue_ = defaultValue;
    factory_ = null;
  };
  /**
   * this can be useful for storing instances,
   * to make sure they get passed to other methods later.
   * @param factory
   */
  public ArgMap(I_ArgFactory<T> factory) {
    defaultValue_ = null;
    factory_ = factory;
  };
  
  public ArgMap(T defaultValue, I_ArgFactory<T> factory) {
    defaultValue_ = defaultValue;
    factory_ = factory;
  };
  
  public int size() {
    return delegate_.size();
  }

  public boolean isEmpty() {
    return delegate_.isEmpty();
  }

  public boolean containsKey(Object key) {
    return delegate_.containsKey(key);
  }

  public boolean containsValue(Object value) {
    return delegate_.containsValue(value);
  }

  public T get(Object key) {
    if (key != null) {
      if (OBJECT_ARRAY_CLASS_NAME.equals(key.getClass().getName())) {
        return delegate_.get(new ObjParams((Object []) key));
      }
    }
    return delegate_.get(key);
  }

  public T get(ObjParams key) {
    return delegate_.get(key);
  }
  
  public T get(Object [] key) {
    return delegate_.get(new ObjParams(key));
  }
  /**
   * note it's getVar to distinguish 
   * between get(1)' and getVar(1);
   * @param key
   * @return
   */
  public T getVar(Object ... key) {
    return delegate_.get(new ObjParams(key));
  }
  
  public T put(ObjParams key, T value) {
    return delegate_.put(key, value);
  }
  
  public T put(Object[] key, T value) {
    return delegate_.put(new ObjParams(key), value);
  }

  public T putVar(T value, Object ... key ) {
    return delegate_.put(new ObjParams(key), value);
  }
  
  public T putDefault(Object ... key ) {
    return delegate_.put(new ObjParams(key), defaultValue_);
  }
  
  public T putFactory(Object ... key ) {
    T value = null;
    if (factory_ != null) {
      value = factory_.create(key);
    }
    return delegate_.put(new ObjParams(key), value);
  }
  
  public T remove(Object key) {
    return delegate_.remove(key);
  }

  public void putAll(Map<? extends ObjParams, ? extends T> m) {
    delegate_.putAll(m);
  }

  public void clear() {
    delegate_.clear();
  }

  public Set<ObjParams> keySet() {
    return delegate_.keySet();
  }

  public Collection<T> values() {
    return delegate_.values();
  }

  public Set<java.util.Map.Entry<ObjParams, T>> entrySet() {
    return delegate_.entrySet();
  }

  public boolean equals(Object o) {
    return delegate_.equals(o);
  }

  public int hashCode() {
    return delegate_.hashCode();
  }

  public T getOrDefault(Object key, T defaultValue) {
    return delegate_.getOrDefault(key, defaultValue);
  }

  public void forEach(BiConsumer<? super ObjParams, ? super T> action) {
    delegate_.forEach(action);
  }

  public void replaceAll(BiFunction<? super ObjParams, ? super T, ? extends T> function) {
    delegate_.replaceAll(function);
  }

  public T putIfAbsent(ObjParams key, T value) {
    return delegate_.putIfAbsent(key, value);
  }

  public boolean remove(Object key, Object value) {
    return delegate_.remove(key, value);
  }

  public boolean replace(ObjParams key, T oldValue, T newValue) {
    return delegate_.replace(key, oldValue, newValue);
  }

  public T replace(ObjParams key, T value) {
    return delegate_.replace(key, value);
  }

  public T computeIfAbsent(ObjParams key,
      Function<? super ObjParams, ? extends T> mappingFunction) {
    return delegate_.computeIfAbsent(key, mappingFunction);
  }

  public T computeIfPresent(ObjParams key,
      BiFunction<? super ObjParams, ? super T, ? extends T> remappingFunction) {
    return delegate_.computeIfPresent(key, remappingFunction);
  }

  public T compute(ObjParams key,
      BiFunction<? super ObjParams, ? super T, ? extends T> remappingFunction) {
    return delegate_.compute(key, remappingFunction);
  }

  public T merge(ObjParams key, T value,
      BiFunction<? super T, ? super T, ? extends T> remappingFunction) {
    return delegate_.merge(key, value, remappingFunction);
  }

  
}
