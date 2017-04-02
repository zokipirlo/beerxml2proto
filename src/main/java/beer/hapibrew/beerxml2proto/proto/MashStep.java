// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: beer.proto at 174:1
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

public final class MashStep extends AndroidMessage<MashStep, MashStep.Builder> {
  public static final ProtoAdapter<MashStep> ADAPTER = new ProtoAdapter_MashStep();

  public static final Parcelable.Creator<MashStep> CREATOR = AndroidMessage.newCreator(ADAPTER);

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  public static final Integer DEFAULT_VERSION = 1;

  public static final Double DEFAULT_STEP_TEMP = 0.0d;

  public static final Double DEFAULT_STEP_TIME = 0.0d;

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
  public final Double step_temp;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  @Nullable
  public final Double step_time;

  public MashStep(@Nullable String name, @Nullable Integer version, @Nullable Double step_temp, @Nullable Double step_time) {
    this(name, version, step_temp, step_time, ByteString.EMPTY);
  }

  public MashStep(@Nullable String name, @Nullable Integer version, @Nullable Double step_temp, @Nullable Double step_time, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.name = name;
    this.version = version;
    this.step_temp = step_temp;
    this.step_time = step_time;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.version = version;
    builder.step_temp = step_temp;
    builder.step_time = step_time;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof MashStep)) return false;
    MashStep o = (MashStep) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(name, o.name)
        && Internal.equals(version, o.version)
        && Internal.equals(step_temp, o.step_temp)
        && Internal.equals(step_time, o.step_time);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (version != null ? version.hashCode() : 0);
      result = result * 37 + (step_temp != null ? step_temp.hashCode() : 0);
      result = result * 37 + (step_time != null ? step_time.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (name != null) builder.append(", name=").append(name);
    if (version != null) builder.append(", version=").append(version);
    if (step_temp != null) builder.append(", step_temp=").append(step_temp);
    if (step_time != null) builder.append(", step_time=").append(step_time);
    return builder.replace(0, 2, "MashStep{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<MashStep, Builder> {
    public String name;

    public Integer version;

    public Double step_temp;

    public Double step_time;

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

    public Builder step_temp(Double step_temp) {
      this.step_temp = step_temp;
      return this;
    }

    public Builder step_time(Double step_time) {
      this.step_time = step_time;
      return this;
    }

    @Override
    public MashStep build() {
      return new MashStep(name, version, step_temp, step_time, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_MashStep extends ProtoAdapter<MashStep> {
    ProtoAdapter_MashStep() {
      super(FieldEncoding.LENGTH_DELIMITED, MashStep.class);
    }

    @Override
    public int encodedSize(MashStep value) {
      return (value.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) : 0)
          + (value.version != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, value.version) : 0)
          + (value.step_temp != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(3, value.step_temp) : 0)
          + (value.step_time != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(4, value.step_time) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, MashStep value) throws IOException {
      if (value.name != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
      if (value.version != null) ProtoAdapter.INT32.encodeWithTag(writer, 2, value.version);
      if (value.step_temp != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 3, value.step_temp);
      if (value.step_time != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 4, value.step_time);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public MashStep decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.version(ProtoAdapter.INT32.decode(reader)); break;
          case 3: builder.step_temp(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 4: builder.step_time(ProtoAdapter.DOUBLE.decode(reader)); break;
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
    public MashStep redact(MashStep value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
