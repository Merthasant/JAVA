package bills;

import relations.Promise;

abstract class Bills {
    protected long amount;
    protected Promise promise;

    public Bills(long amount, Promise promise) {
        this.amount = amount;
        this.promise = promise;
    }

    public long getAmount() {
        return amount;
    }

    public Promise getPromise() {
        return promise;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public abstract long getBills();
}
