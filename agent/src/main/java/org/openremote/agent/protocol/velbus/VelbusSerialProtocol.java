/*
 * Copyright 2017, OpenRemote Inc.
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
package org.openremote.agent.protocol.velbus;

import io.netty.channel.ChannelHandler;
import org.openremote.agent.protocol.io.AbstractNettyIoClient;
import org.openremote.agent.protocol.io.IoClient;
import org.openremote.agent.protocol.serial.SerialIoClient;
import org.openremote.model.protocol.ProtocolInstanceDiscovery;
import org.openremote.model.util.TextUtil;

public class VelbusSerialProtocol extends AbstractVelbusProtocol<VelbusSerialAgent> {

    public static final String PROTOCOL_DISPLAY_NAME = "VELBUS Serial";
    public static final int DEFAULT_BAUDRATE = 38400;

    public VelbusSerialProtocol(VelbusSerialAgent agent) {
        super(agent);
    }

    @Override
    public String getProtocolName() {
        return PROTOCOL_DISPLAY_NAME;
    }

    @Override
    protected IoClient<VelbusPacket> createIoClient(VelbusSerialAgent agent) throws RuntimeException {

        // Extract port and baud rate
        String port = agent.getSerialPort().orElse(null);
        int baudRate = agent.getSerialBaudrate().orElse(DEFAULT_BAUDRATE);

        TextUtil.requireNonNullAndNonEmpty(port, "Port cannot be null or empty");
        SerialIoClient<VelbusPacket> client = new SerialIoClient<>(port, baudRate, executorService);

        client.setEncoderDecoderProvider(
            () -> new ChannelHandler[]{
                new VelbusPacketEncoder(),
                new VelbusPacketDecoder(),
                new AbstractNettyIoClient.MessageToMessageDecoder<>(VelbusPacket.class, client)
            }
        );
        return client;
    }
}
