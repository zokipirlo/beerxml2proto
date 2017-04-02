// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 78:1
package beer.hapibrew.beerxml2proto.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.lang.Override;

public enum HopForm implements WireEnum {
  PELLET(0),

  PLUG(1),

  LEAF(2);

  public static final ProtoAdapter<HopForm> ADAPTER = ProtoAdapter.newEnumAdapter(HopForm.class);

  private final int value;

  HopForm(int value) {
    this.value = value;
  }

  /**
   * Return the constant for {@code value} or null.
   */
  public static HopForm fromValue(int value) {
    switch (value) {
      case 0: return PELLET;
      case 1: return PLUG;
      case 2: return LEAF;
      default: return null;
    }
  }

  @Override
  public int getValue() {
    return value;
  }
}
