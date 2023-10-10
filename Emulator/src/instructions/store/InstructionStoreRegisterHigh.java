package instructions.store;

import emulator.Emulator;
import instructions.Instruction;
import instructions.InstructionManager;

public class InstructionStoreRegisterHigh extends Instruction {

    public InstructionStoreRegisterHigh(Emulator emulator, byte register, byte dataHigh, byte dataLow) {
        super(emulator, InstructionManager.OPCODE_STORE_REGISTER_HIGH, register, dataHigh, dataLow);
    }

    @Override
    public void execute() {
        int index = emulator.getRegisterValue(dataLow)[0];
        index = index << 8;
        index += emulator.getRegisterValue(dataLow)[1];
        emulator.setMemoryByte(index, emulator.getRegisterValue(register)[0]);
    }
    
}
