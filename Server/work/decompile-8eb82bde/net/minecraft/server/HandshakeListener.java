package net.minecraft.server;

public class HandshakeListener implements PacketHandshakingInListener {

    private final MinecraftServer a;
    private final NetworkManager b;

    public HandshakeListener(MinecraftServer minecraftserver, NetworkManager networkmanager) {
        this.a = minecraftserver;
        this.b = networkmanager;
    }

    public void a(PacketHandshakingInSetProtocol packethandshakinginsetprotocol) {
        switch (ProtocolOrdinalWrapper.a[packethandshakinginsetprotocol.a().ordinal()]) {
        case 1:
            this.b.a(EnumProtocol.LOGIN);
            ChatComponentText chatcomponenttext;

            if (packethandshakinginsetprotocol.b() > 47) {
                chatcomponenttext = new ChatComponentText("Outdated server! I\'m still on 1.8");
                this.b.handle(new PacketLoginOutDisconnect(chatcomponenttext));
                this.b.close(chatcomponenttext);
            } else if (packethandshakinginsetprotocol.b() < 47) {
                chatcomponenttext = new ChatComponentText("Outdated client! Please use 1.8");
                this.b.handle(new PacketLoginOutDisconnect(chatcomponenttext));
                this.b.close(chatcomponenttext);
            } else {
                this.b.a((PacketListener) (new LoginListener(this.a, this.b)));
            }
            break;

        case 2:
            this.b.a(EnumProtocol.STATUS);
            this.b.a((PacketListener) (new PacketStatusListener(this.a, this.b)));
            break;

        default:
            throw new UnsupportedOperationException("Invalid intention " + packethandshakinginsetprotocol.a());
        }

    }

    public void a(IChatBaseComponent ichatbasecomponent) {}
}
