package bills;

import relations.Promise;

public class CommonBills extends Bills{
    public CommonBills(long amount, Promise promise) {
        super(amount,promise);
    }
    @Override
    public long getBills() {
        return this.amount + this.promise.getDoctor().getFees();
    }
}
