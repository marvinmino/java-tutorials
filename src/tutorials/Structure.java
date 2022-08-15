package tutorials;

import tutorials.Services.MessageService;
import tutorials.Services.ScannerService;
import tutorials.resources.Result;

public class Structure {
    public static void main(String[] args){
        MessageService messageService = new MessageService();
        ScannerService scannerService = new ScannerService();
        try{
            messageService.startMessage();
            String type = scannerService.initialScan();
            Result data = scannerService.scanByType(type);
            messageService.printByType(type, data);
            scannerService.invokeByType(type, data);
        } catch(Exception e){
            messageService.restartMessage();
        }

        main(args);
    }
}
