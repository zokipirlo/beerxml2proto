// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 133:1
package beer.hapibrew.beerxml2proto.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.lang.Override;

public enum YeastType implements WireEnum {
  ALE(0),

  LAGER(1),

  WHEAT(2),

  WINE(3),

  CHAMPAGNE(4);

  public static final ProtoAdapter<YeastType> ADAPTER = ProtoAdapter.newEnumAdapter(YeastType.class);

  private final int value;

  YeastType(int value) {
    this.value = value;
  }

  /**
   * Return the constant for {@code value} or null.
   */
  public static YeastType fromValue(int value) {
    switch (value) {
      case 0: return ALE;
      case 1: return LAGER;
      case 2: return WHEAT;
      case 3: return WINE;
      case 4: return CHAMPAGNE;
      default: return null;
    }
  }

  @Override
  public int getValue() {
    return value;
  }
}
