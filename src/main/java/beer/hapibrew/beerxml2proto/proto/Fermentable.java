// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 95:1
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

public final class Fermentable extends AndroidMessage<Fermentable, Fermentable.Builder> {
  public static final ProtoAdapter<Fermentable> ADAPTER = new ProtoAdapter_Fermentable();

  public static final Parcelable.Creator<Fermentable> CREATOR = AndroidMessage.newCreator(ADAPTER);

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  public static final Integer DEFAULT_VERSION = 1;

  public static final String DEFAULT_TYPE = "";

  public static final Double DEFAULT_AMOUNT = 0.0d;

  public static final Double DEFAULT_YIELD = 0.0d;

  public static final Double DEFAULT_COLOR = 0.0d;

  public static final Double DEFAULT_POTENTIAL = 1.000d;

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
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @Nullable
  public final String type;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double amount;

  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double yield;

  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double color;

  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double potential;

  @WireField(
      tag = 8,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  @Nullable
  public final String notes;

  public Fermentable(@Nullable String name, @Nullable Integer version, @Nullable String type, @Nullable Double amount, @Nullable Double yield, @Nullable Double color, @Nullable Double potential, @Nullable String notes) {
    this(name, version, type, amount, yield, color, potential, notes, ByteString.EMPTY);
  }

  public Fermentable(@Nullable String name, @Nullable Integer version, @Nullable String type, @Nullable Double amount, @Nullable Double yield, @Nullable Double color, @Nullable Double potential, @Nullable String notes, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.name = name;
    this.version = version;
    this.type = type;
    this.amount = amount;
    this.yield = yield;
    this.color = color;
    this.potential = potential;
    this.notes = notes;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.version = version;
    builder.type = type;
    builder.amount = amount;
    builder.yield = yield;
    builder.color = color;
    builder.potential = potential;
    builder.notes = notes;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Fermentable)) return false;
    Fermentable o = (Fermentable) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(name, o.name)
        && Internal.equals(version, o.version)
        && Internal.equals(type, o.type)
        && Internal.equals(amount, o.amount)
        && Internal.equals(yield, o.yield)
        && Internal.equals(color, o.color)
        && Internal.equals(potential, o.potential)
        && Internal.equals(notes, o.notes);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (version != null ? version.hashCode() : 0);
      result = result * 37 + (type != null ? type.hashCode() : 0);
      result = result * 37 + (amount != null ? amount.hashCode() : 0);
      result = result * 37 + (yield != null ? yield.hashCode() : 0);
      result = result * 37 + (color != null ? color.hashCode() : 0);
      result = result * 37 + (potential != null ? potential.hashCode() : 0);
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
    if (type != null) builder.append(", type=").append(type);
    if (amount != null) builder.append(", amount=").append(amount);
    if (yield != null) builder.append(", yield=").append(yield);
    if (color != null) builder.append(", color=").append(color);
    if (potential != null) builder.append(", potential=").append(potential);
    if (notes != null) builder.append(", notes=").append(notes);
    return builder.replace(0, 2, "Fermentable{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Fermentable, Builder> {
    public String name;

    public Integer version;

    public String type;

    public Double amount;

    public Double yield;

    public Double color;

    public Double potential;

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

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public Builder amount(Double amount) {
      this.amount = amount;
      return this;
    }

    public Builder yield(Double yield) {
      this.yield = yield;
      return this;
    }

    public Builder color(Double color) {
      this.color = color;
      return this;
    }

    public Builder potential(Double potential) {
      this.potential = potential;
      return this;
    }

    public Builder notes(String notes) {
      this.notes = notes;
      return this;
    }

    @Override
    public Fermentable build() {
      return new Fermentable(name, version, type, amount, yield, color, potential, notes, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Fermentable extends ProtoAdapter<Fermentable> {
    ProtoAdapter_Fermentable() {
      super(FieldEncoding.LENGTH_DELIMITED, Fermentable.class);
    }

    @Override
    public int encodedSize(Fermentable value) {
      return (value.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) : 0)
          + (value.version != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, value.version) : 0)
          + (value.type != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value.type) : 0)
          + (value.amount != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(4, value.amount) : 0)
          + (value.yield != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(5, value.yield) : 0)
          + (value.color != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(6, value.color) : 0)
          + (value.potential != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(7, value.potential) : 0)
          + (value.notes != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, value.notes) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Fermentable value) throws IOException {
      if (value.name != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
      if (value.version != null) ProtoAdapter.INT32.encodeWithTag(writer, 2, value.version);
      if (value.type != null) ProtoAdapter.STRING.encodeWithTag(writer, 3, value.type);
      if (value.amount != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 4, value.amount);
      if (value.yield != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 5, value.yield);
      if (value.color != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 6, value.color);
      if (value.potential != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 7, value.potential);
      if (value.notes != null) ProtoAdapter.STRING.encodeWithTag(writer, 8, value.notes);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Fermentable decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.version(ProtoAdapter.INT32.decode(reader)); break;
          case 3: builder.type(ProtoAdapter.STRING.decode(reader)); break;
          case 4: builder.amount(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 5: builder.yield(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 6: builder.color(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 7: builder.potential(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 8: builder.notes(ProtoAdapter.STRING.decode(reader)); break;
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
    public Fermentable redact(Fermentable value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
