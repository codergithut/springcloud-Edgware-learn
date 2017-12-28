package tianjian.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tianjian.bean.VehicleDetails;

@RestController
public interface UserVehicleService {

    /**
     * @param sboot
     * @return 该方式测试处理失败,但是程序没啥问题需要定位问题
     */
    @GetMapping("/{sboot}/vehicle")
    VehicleDetails getVehicleDetails(@PathVariable(name = "sboot") String sboot);

    @GetMapping("/sboot/vehicle")
    VehicleDetails getVehicleDetails();

}
