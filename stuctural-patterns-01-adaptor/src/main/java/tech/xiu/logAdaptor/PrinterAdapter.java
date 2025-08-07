package tech.xiu.logAdaptor;

// 适配器
class PrinterAdapter implements LogPrinter {
    private LegacyPrinter legacy;

    public PrinterAdapter(LegacyPrinter legacy) {
        this.legacy = legacy;
    }

    public void print(String message) {
        legacy.output(message);
    }
}
