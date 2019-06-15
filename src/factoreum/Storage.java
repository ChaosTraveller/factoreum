package factoreum;

public class Storage implements IStorageRaw, IStorageItems{

    private static Storage ourInstance = new Storage();

    private static Storage single_instance = null;

    public static Storage getInstance()
    {
        if (single_instance == null)
            single_instance = new Storage();

        return single_instance;
    }

                                    // Zmienne związanie z przedmiotami, energią, itp
    private  int maxPower = 0;
    private  int powerUsage = 0;
    private  int units = 1000;
    private  int coal = 0;
    private  int titanium = 0;
    private  int crystals = 0;
    private  int uranium = 0;
//    private  int coolingPower = 0;
//    private  int heatingPower = 0;

    private  int graphite = 0;
    private  int graphiteRod = 0;
    private  int controlRod = 0;
    private  int titaniumPlate = 0;
    private  int fuelRod = 0;
    private  int advancedFuelRod = 0;
    private  int electronicParts = 0;
    private  int powerTransmiter = 0;
    private  int pureCrystal = 0;
    private  int reinforcedTiPlate = 0;
    private  int electronicCircute = 0;








    public int getMaxPower() { return maxPower; }
    public void setMaxPower(int maxPower) { this.maxPower = maxPower; }
    public int getPowerUsage() { return powerUsage; }
    public void setPowerUsage(int powerUsage) { this.powerUsage = powerUsage; }
    public int getUnits() { return units; }
    public void setUnits(int units) { this.units = units; }
    public int getCoal() { return coal; }
    public void setCoal(int coal) { this.coal = coal; }
    public int getTitanium() { return titanium; }
    public void setTitanium(int titanium) { this.titanium = titanium; }
    public int getCrystals() { return crystals; }
    public void setCrystals(int crystals) { this.crystals = crystals; }
    public int getUranium() { return uranium; }
    public void setUranium(int uranium) { this.uranium = uranium; }
//    public int getCoolingPower() { return coolingPower; }
//    public void setCoolingPower(int coolingPower) { this.coolingPower = coolingPower; }
//    public int getHeatingPower() { return heatingPower; }
//    public void setHeatingPower(int heatingPower) { this.heatingPower = heatingPower;}


    public int getGraphite() { return graphite; }
    public void setGraphite(int graphite) { this.graphite = graphite; }
    public int getGraphiteRod() { return graphiteRod; }
    public void setGraphiteRod(int graphiteRod) { this.graphiteRod = graphiteRod; }
    public int getControlRod() { return controlRod; }
    public void setControlRod(int controlRod) { this.controlRod = controlRod; }
    public int getTitaniumPlate() { return titaniumPlate; }
    public void setTitaniumPlate(int titaniumPlate) { this.titaniumPlate = titaniumPlate; }
    public int getFuelRod() { return fuelRod; }
    public void setFuelRod(int fuelRod) { this.fuelRod = fuelRod; }
    public int getAdvancedFuelRod() { return advancedFuelRod; }
    public void setAdvancedFuelRod(int advancedFuelRod) { this.advancedFuelRod = advancedFuelRod; }
    public int getElectronicParts() { return electronicParts; }
    public void setElectronicParts(int electronicParts) { this.electronicParts = electronicParts; }
    public int getPowerTransmiter() { return powerTransmiter; }
    public void setPowerTransmiter(int powerTransmiter) { this.powerTransmiter = powerTransmiter; }
    public int getPureCrystal() { return pureCrystal; }
    public void setPureCrystal(int pureCrystal) { this.pureCrystal = pureCrystal; }
    public int getReinforcedTiPlate() { return reinforcedTiPlate; }
    public void setReinforcedTiPlate(int reinforcedTiPlate) { this.reinforcedTiPlate = reinforcedTiPlate; }
    public int getElectronicCircute() { return electronicCircute; }
    public void setElectronicCircute(int electronicCircute) { this.electronicCircute = electronicCircute; }

}

