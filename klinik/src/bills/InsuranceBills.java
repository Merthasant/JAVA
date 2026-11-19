package bills;

import relations.Promise;

public class InsuranceBills extends Bills{
    private int insurancePercent;

    public InsuranceBills(long amount, Promise promise,int insurancePercent) {
        if(insurancePercent > 100 || insurancePercent < 1) {
            throw new Error("invalid insurance");
        }
        super(amount,promise);
        this.insurancePercent = insurancePercent;
    }

    @Override
    public long getBills() {
        return this.amount - this.amount * (this.insurancePercent/100);
    }

    public int getInsurancePercent() {
        return insurancePercent;
    }

    public void setInsurancePercent(int insurancePercent) {
        if(insurancePercent > 100 || insurancePercent < 1) {
            throw new Error("invalid insurance");
        }
        this.insurancePercent = insurancePercent;
    }
}
