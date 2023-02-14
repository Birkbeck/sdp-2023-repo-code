package structural.adapter.current;

/*
 * Using inheritance for adapter pattern
 */
public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get240Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 20);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 80);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }

}