// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 73:1
package beer.hapibrew.beerxml2proto.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.lang.Override;

public enum HopType implements WireEnum {
  BITTERING(0),

  AROMA(1),

  BOTH(2);

  public static final ProtoAdapter<HopType> ADAPTER = ProtoAdapter.newEnumAdapter(HopType.class);

  private final int value;

  HopType(int value) {
    this.value = value;
  }

  /**
   * Return the constant for {@code value} or null.
   */
  public static HopType fromValue(int value) {
    switch (value) {
      case 0: return BITTERING;
      case 1: return AROMA;
      case 2: return BOTH;
      default: return null;
    }
  }

  @Override
  public int getValue() {
    return value;
  }
}
