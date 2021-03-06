// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 83:1
package beer.hapibrew.beerxml2proto.proto;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class Hop extends AndroidMessage<Hop, Hop.Builder> {
  public static final ProtoAdapter<Hop> ADAPTER = new ProtoAdapter_Hop();

  public static final Parcelable.Creator<Hop> CREATOR = AndroidMessage.newCreator(ADAPTER);

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  public static final Integer DEFAULT_VERSION = 1;

  public static final Double DEFAULT_ALPHA = 0.0d;

  public static final Double DEFAULT_AMOUNT = 0.0d;

  public static final HopUse DEFAULT_USE = HopUse.BOIL;

  public static final Double DEFAULT_TIME = 0.0d;

  public static final HopType DEFAULT_TYPE = HopType.BITTERING;

  public static final HopForm DEFAULT_FORM = HopForm.PELLET;

  public static final String DEFAULT_NOTES = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @Nullable
  public final String name;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  @Nullable
  public final Integer version;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double alpha;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double amount;

  @WireField(
      tag = 5,
      adapter = "beer.hapibrew.beerxml2proto.proto.HopUse#ADAPTER"
  )
  @Nullable
  public final HopUse use;

  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double time;

  @WireField(
      tag = 7,
      adapter = "beer.hapibrew.beerxml2proto.proto.HopType#ADAPTER"
  )
  @Nullable
  public final HopType type;

  @WireField(
      tag = 8,
      adapter = "beer.hapibrew.beerxml2proto.proto.HopForm#ADAPTER"
  )
  @Nullable
  public final HopForm form;

  @WireField(
      tag = 9,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @Nullable
  public final String notes;

  public Hop(@Nullable String name, @Nullable Integer version, @Nullable Double alpha, @Nullable Double amount, @Nullable HopUse use, @Nullable Double time, @Nullable HopType type, @Nullable HopForm form, @Nullable String notes) {
    this(name, version, alpha, amount, use, time, type, form, notes, ByteString.EMPTY);
  }

  public Hop(@Nullable String name, @Nullable Integer version, @Nullable Double alpha, @Nullable Double amount, @Nullable HopUse use, @Nullable Double time, @Nullable HopType type, @Nullable HopForm form, @Nullable String notes, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.name = name;
    this.version = version;
    this.alpha = alpha;
    this.amount = amount;
    this.use = use;
    this.time = time;
    this.type = type;
    this.form = form;
    this.notes = notes;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.version = version;
    builder.alpha = alpha;
    builder.amount = amount;
    builder.use = use;
    builder.time = time;
    builder.type = type;
    builder.form = form;
    builder.notes = notes;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Hop)) return false;
    Hop o = (Hop) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(name, o.name)
        && Internal.equals(version, o.version)
        && Internal.equals(alpha, o.alpha)
        && Internal.equals(amount, o.amount)
        && Internal.equals(use, o.use)
        && Internal.equals(time, o.time)
        && Internal.equals(type, o.type)
        && Internal.equals(form, o.form)
        && Internal.equals(notes, o.notes);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (version != null ? version.hashCode() : 0);
      result = result * 37 + (alpha != null ? alpha.hashCode() : 0);
      result = result * 37 + (amount != null ? amount.hashCode() : 0);
      result = result * 37 + (use != null ? use.hashCode() : 0);
      result = result * 37 + (time != null ? time.hashCode() : 0);
      result = result * 37 + (type != null ? type.hashCode() : 0);
      result = result * 37 + (form != null ? form.hashCode() : 0);
      result = result * 37 + (notes != null ? notes.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (name != null) builder.append(", name=").append(name);
    if (version != null) builder.append(", version=").append(version);
    if (alpha != null) builder.append(", alpha=").append(alpha);
    if (amount != null) builder.append(", amount=").append(amount);
    if (use != null) builder.append(", use=").append(use);
    if (time != null) builder.append(", time=").append(time);
    if (type != null) builder.append(", type=").append(type);
    if (form != null) builder.append(", form=").append(form);
    if (notes != null) builder.append(", notes=").append(notes);
    return builder.replace(0, 2, "Hop{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Hop, Builder> {
    public String name;

    public Integer version;

    public Double alpha;

    public Double amount;

    public HopUse use;

    public Double time;

    public HopType type;

    public HopForm form;

    public String notes;

    public Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder version(Integer version) {
      this.version = version;
      return this;
    }

    public Builder alpha(Double alpha) {
      this.alpha = alpha;
      return this;
    }

    public Builder amount(Double amount) {
      this.amount = amount;
      return this;
    }

    public Builder use(HopUse use) {
      this.use = use;
      return this;
    }

    public Builder time(Double time) {
      this.time = time;
      return this;
    }

    public Builder type(HopType type) {
      this.type = type;
      return this;
    }

    public Builder form(HopForm form) {
      this.form = form;
      return this;
    }

    public Builder notes(String notes) {
      this.notes = notes;
      return this;
    }

    @Override
    public Hop build() {
      return new Hop(name, version, alpha, amount, use, time, type, form, notes, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Hop extends ProtoAdapter<Hop> {
    ProtoAdapter_Hop() {
      super(FieldEncoding.LENGTH_DELIMITED, Hop.class);
    }

    @Override
    public int encodedSize(Hop value) {
      return (value.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) : 0)
          + (value.version != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, value.version) : 0)
          + (value.alpha != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(3, value.alpha) : 0)
          + (value.amount != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(4, value.amount) : 0)
          + (value.use != null ? HopUse.ADAPTER.encodedSizeWithTag(5, value.use) : 0)
          + (value.time != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(6, value.time) : 0)
          + (value.type != null ? HopType.ADAPTER.encodedSizeWithTag(7, value.type) : 0)
          + (value.form != null ? HopForm.ADAPTER.encodedSizeWithTag(8, value.form) : 0)
          + (value.notes != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, value.notes) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Hop value) throws IOException {
      if (value.name != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
      if (value.version != null) ProtoAdapter.INT32.encodeWithTag(writer, 2, value.version);
      if (value.alpha != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 3, value.alpha);
      if (value.amount != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 4, value.amount);
      if (value.use != null) HopUse.ADAPTER.encodeWithTag(writer, 5, value.use);
      if (value.time != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 6, value.time);
      if (value.type != null) HopType.ADAPTER.encodeWithTag(writer, 7, value.type);
      if (value.form != null) HopForm.ADAPTER.encodeWithTag(writer, 8, value.form);
      if (value.notes != null) ProtoAdapter.STRING.encodeWithTag(writer, 9, value.notes);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Hop decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.version(ProtoAdapter.INT32.decode(reader)); break;
          case 3: builder.alpha(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 4: builder.amount(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 5: {
            try {
              builder.use(HopUse.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 6: builder.time(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 7: {
            try {
              builder.type(HopType.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 8: {
            try {
              builder.form(HopForm.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 9: builder.notes(ProtoAdapter.STRING.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public Hop redact(Hop value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
