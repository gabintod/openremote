/*
 * Copyright 2020, OpenRemote Inc.
 *
 * See the CONTRIBUTORS.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openremote.model.asset.impl;

import org.openremote.model.Constants;
import org.openremote.model.asset.AssetDescriptor;
import org.openremote.model.attribute.MetaItem;
import org.openremote.model.v2.AttributeDescriptor;
import org.openremote.model.v2.MetaItemType;
import org.openremote.model.v2.ValueType;
import org.openremote.model.value.ColourRGB;
import org.openremote.model.value.ColourRGBA;
import org.openremote.model.value.ColourRGBAW;
import org.openremote.model.value.ColourRGBW;

import java.util.Optional;

public class LightAsset extends DeviceAsset {

    public static final AttributeDescriptor<Boolean> ON_OFF = new AttributeDescriptor<>("onOff", false, ValueType.BOOLEAN,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_ON_OFF)
    );

    public static final AttributeDescriptor<Integer> BRIGHTNESS = new AttributeDescriptor<>("brightness", true, ValueType.PERCENTAGE_INTEGER_0_100);

    public static final AttributeDescriptor<ColourRGB> COLOUR_RGB = new AttributeDescriptor<>("colourRGB", true, ValueType.COLOUR_RGB);
    public static final AttributeDescriptor<ColourRGBA> COLOUR_RGBA = new AttributeDescriptor<>("colourRGBA", true, ValueType.COLOUR_RGBA);
    public static final AttributeDescriptor<ColourRGBW> COLOUR_RGBW = new AttributeDescriptor<>("colourRGBW", true, ValueType.COLOUR_RGBW);
    public static final AttributeDescriptor<ColourRGBAW> COLOUR_RGBAW = new AttributeDescriptor<>("colourRGBAW", true, ValueType.COLOUR_RGBAW);

    public static final AttributeDescriptor<Integer> TEMPERATURE = new AttributeDescriptor<>("temperature", true, ValueType.POSITIVE_INTEGER);

    public static final AssetDescriptor<LightAsset> DESCRIPTOR = new AssetDescriptor<>("lightbulb", "e6688a", LightAsset.class);

    public <T extends LightAsset> LightAsset(String name, AssetDescriptor<T> descriptor) {
        super(name, descriptor);
    }

    public LightAsset(String name) {
        super(name, DESCRIPTOR);
    }

    public Optional<Boolean> getOnOff() {
        return getAttributes().getValue(ON_OFF);
    }

    public Optional<Integer> getBrightness() {
        return getAttributes().getValue(BRIGHTNESS);
    }

    public Optional<ColourRGB> getColorRGB() {
        return getAttributes().getValue(COLOUR_RGB);
    }

    public Optional<ColourRGBA> getColorRGBA() {
        return getAttributes().getValue(COLOUR_RGBA);
    }

    public Optional<ColourRGBW> getColorRGBW() {
        return getAttributes().getValue(COLOUR_RGBW);
    }

    public Optional<ColourRGBAW> getColorRGBAW() {
        return getAttributes().getValue(COLOUR_RGBAW);
    }

    public Optional<Integer> getTemperature() {
        return getAttributes().getValue(TEMPERATURE);
    }
}