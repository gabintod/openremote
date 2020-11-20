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

import java.util.Optional;

public class ElectricityStorageAsset extends DeviceAsset {

    public static final AttributeDescriptor<String> STATUS = new AttributeDescriptor<>("status", true, ValueType.STRING,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> LEVELISED_COST_OF_STORAGE = new AttributeDescriptor<>("levelisedCostOfStorage", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_CURRENCY_EUR)
    );
    public static final AttributeDescriptor<Double> ENERGY_CAPACITY = new AttributeDescriptor<>("energyCapacity", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_ENERGY_KILOWATT_HOUR),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Integer> ENERGY_AVAILABLE_PERCENTAGE = new AttributeDescriptor<>("energyAvailablePercentage", true, ValueType.PERCENTAGE_INTEGER_0_100);
    public static final AttributeDescriptor<Double> ENERGY_AVAILABLE = new AttributeDescriptor<>("energyAvailable", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_ENERGY_KILOWATT_HOUR),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> ENERGY_CAPACITY_REMAINING = new AttributeDescriptor<>("energyCapacityRemaining", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_ENERGY_KILOWATT_HOUR),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> ENERGY_TOTAL_IMPORT = new AttributeDescriptor<>("energyTotalImport", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_ENERGY_KILOWATT_HOUR),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> ENERGY_TOTAL_EXPORT = new AttributeDescriptor<>("energyTotalExport", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_ENERGY_KILOWATT_HOUR),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> POWER_CAPACITY_IMPORT = new AttributeDescriptor<>("powerCapacityImport", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_POWER_KILOWATT)
    );
    public static final AttributeDescriptor<Double> POWER_CAPACITY_EXPORT = new AttributeDescriptor<>("powerCapacityExport", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_POWER_KILOWATT)
    );
    public static final AttributeDescriptor<Double> POWER_TOTAL = new AttributeDescriptor<>("powerTotal", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_POWER_KILOWATT),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> POWER_SETPOINT = new AttributeDescriptor<>("powerSetpoint", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_POWER_KILOWATT)
    );
    public static final AttributeDescriptor<Integer> CHARGE_CYCLES = new AttributeDescriptor<>("chargeCycles", true, ValueType.POSITIVE_INTEGER,
        new MetaItem<>(MetaItemType.READ_ONLY)
    );
    public static final AttributeDescriptor<Double> FINANCIAL_WALLET = new AttributeDescriptor<>("financialWallet", true, ValueType.POSITIVE_NUMBER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_CURRENCY_EUR)
    );
    public static final AttributeDescriptor<Integer> CARBON_WALLET = new AttributeDescriptor<>("carbonWallet", true, ValueType.POSITIVE_INTEGER,
        new MetaItem<>(MetaItemType.UNIT_TYPE, Constants.UNITS_MASS_KILOGRAM),
        new MetaItem<>(MetaItemType.READ_ONLY)
    );

    public static final AssetDescriptor<ElectricityStorageAsset> DESCRIPTOR = new AssetDescriptor<>("battery-charging", "1B7C89", ElectricityStorageAsset.class);

    public ElectricityStorageAsset(String name) {
        super(name, DESCRIPTOR);
    }

    public Optional<String> getStatus() {
        return getAttributes().getValue(STATUS);
    }

    public Optional<Double> getLevelisedCostOfStorage() {
        return getAttributes().getValue(LEVELISED_COST_OF_STORAGE);
    }

    public Optional<Double> getEnergyCapacity() {
        return getAttributes().getValue(ENERGY_CAPACITY);
    }

    public Optional<Integer> getEnergyAvailablePercentage() {
        return getAttributes().getValue(ENERGY_AVAILABLE_PERCENTAGE);
    }

    public Optional<Double> getEnergyAvailable() {
        return getAttributes().getValue(ENERGY_AVAILABLE);
    }

    public Optional<Double> getEnergyCapacityRemaining() {
        return getAttributes().getValue(ENERGY_CAPACITY_REMAINING);
    }

    public Optional<Double> getEnergyTotalImport() {
        return getAttributes().getValue(ENERGY_TOTAL_IMPORT);
    }

    public Optional<Double> getEnergyTotalExport() {
        return getAttributes().getValue(ENERGY_TOTAL_EXPORT);
    }

    public Optional<Double> getPowerCapacityImport() {
        return getAttributes().getValue(POWER_CAPACITY_IMPORT);
    }

    public Optional<Double> getPowerCapacityExport() {
        return getAttributes().getValue(POWER_CAPACITY_EXPORT);
    }

    public Optional<Double> getPowerTotal() {
        return getAttributes().getValue(POWER_TOTAL);
    }

    public Optional<Double> getPowerSetpoint() {
        return getAttributes().getValue(POWER_SETPOINT);
    }

    public Optional<Integer> getChargeCycles() {
        return getAttributes().getValue(CHARGE_CYCLES);
    }

    public Optional<Double> getFinancialWallet() {
        return getAttributes().getValue(FINANCIAL_WALLET);
    }

    public Optional<Integer> getCarbonWallet() {
        return getAttributes().getValue(CARBON_WALLET);
    }
}