
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class ProcessorInfo {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        String processorName = osBean.getProcessor();
        System.out.println("Processor Name: " + processorName);
    }
}


package com.fedx.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FedxapiApplicationTests {

	@Test
	void contextLoads() {
	}

}
