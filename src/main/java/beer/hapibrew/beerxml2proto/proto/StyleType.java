// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 37:1
package beer.hapibrew.beerxml2proto.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.lang.Override;

public enum StyleType implements WireEnum {
  LAGER(0),

  ALE(1),

  MEAD(2),

  WHEAT(3),

  MIXED(4),

  CIDER(5);

  public static final ProtoAdapter<StyleType> ADAPTER = ProtoAdapter.newEnumAdapter(StyleType.class);

  private final int value;

  StyleType(int value) {
    this.value = value;
  }

  /**
   * Return the constant for {@code value} or null.
   */
  public static StyleType fromValue(int value) {
    switch (value) {
      case 0: return LAGER;
      case 1: return ALE;
      case 2: return MEAD;
      case 3: return WHEAT;
      case 4: return MIXED;
      case 5: return CIDER;
      default: return null;
    }
  }

  @Override
  public int getValue() {
    return value;
  }
}