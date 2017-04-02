// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 66:1
package beer.hapibrew.beerxml2proto.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.lang.Override;

public enum HopUse implements WireEnum {
  /**
   * boil time
   */
  BOIL(0),

  /**
   * amount of dry hop time
   */
  DRY_HOP(1),

  /**
   * mash time
   */
  MASH(2),

  /**
   * boil time
   */
  FIRST_WORT(3),

  /**
   * steep time
   */
  AROMA(4);

  public static final ProtoAdapter<HopUse> ADAPTER = ProtoAdapter.newEnumAdapter(HopUse.class);

  private final int value;

  HopUse(int value) {
    this.value = value;
  }

  /**
   * Return the constant for {@code value} or null.
   */
  public static HopUse fromValue(int value) {
    switch (value) {
      case 0: return BOIL;
      case 1: return DRY_HOP;
      case 2: return MASH;
      case 3: return FIRST_WORT;
      case 4: return AROMA;
      default: return null;
    }
  }

  @Override
  public int getValue() {
    return value;
  }
}
