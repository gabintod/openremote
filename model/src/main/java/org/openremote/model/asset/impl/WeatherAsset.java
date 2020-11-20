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
import org.openremote.model.asset.Asset;
import org.openremote.model.asset.AssetDescriptor;
import org.openremote.model.attribute.MetaItem;
import org.openremote.model.v2.AttributeDescriptor;
import org.openremote.model.v2.MetaItemType;
import org.openremote.model.v2.ValueType;

import java.util.Optional;

public class WeatherAsset extends Asset {

    public static final AttributeDescriptor<Double> TEMPERATURE = new AttributeDescriptor<>("temperature", true, ValueType.NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_TEMPERATURE_CELSIUS),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Integer> UV_INDEX = new AttributeDescriptor<>("uVIndex", false, ValueType.POSITIVE_INTEGER,
        new MetaItem<>(MetaItemType.LABEL, "UV index"),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> SUN_IRRADIANCE = new AttributeDescriptor<>("sunIrradiance", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Integer> SUN_AZIMUTH = new AttributeDescriptor<>("sunAzimuth", true, ValueType.POSITIVE_INTEGER,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Integer> SUN_ZENITH = new AttributeDescriptor<>("sunZenith", true, ValueType.POSITIVE_INTEGER,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Integer> SUN_ALTITUDE = new AttributeDescriptor<>("sunAltitude", true, ValueType.POSITIVE_INTEGER,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> WIND_SPEED = new AttributeDescriptor<>("windSpeed", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_SPEED_KILOMETERS_HOUR),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Integer> WIND_DIRECTION = new AttributeDescriptor<>("sunAltitude", true, ValueType.DIRECTION,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> RAINFALL = new AttributeDescriptor<>("rainfall", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_DISTANCE_MILLIMETRE),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Integer> HUMIDITY = new AttributeDescriptor<>("humidity", true, ValueType.PERCENTAGE_INTEGER_0_100,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );

    public static final AssetDescriptor<WeatherAsset> DESCRIPTOR = new AssetDescriptor<>("weather-partly-cloudy", "49B0D8", WeatherAsset.class);

    public WeatherAsset(String name) {
        super(name, DESCRIPTOR);
    }

    public Optional<Double> getTemperature() {
        return getAttributes().getValue(TEMPERATURE);
    }

    public Optional<Integer> getUVIndex() {
        return getAttributes().getValue(UV_INDEX);
    }

    public Optional<Double> getSunIrradiance() {
        return getAttributes().getValue(SUN_IRRADIANCE);
    }

    public Optional<Integer> getSunAzimuth() {
        return getAttributes().getValue(SUN_AZIMUTH);
    }

    public Optional<Integer> getSunZenith() {
        return getAttributes().getValue(SUN_ZENITH);
    }

    public Optional<Integer> getSunAltitude() {
        return getAttributes().getValue(SUN_ALTITUDE);
    }

    public Optional<Double> getRainfall() {
        return getAttributes().getValue(RAINFALL);
    }

    public Optional<Integer> getHumidity() {
        return getAttributes().getValue(HUMIDITY);
    }
}