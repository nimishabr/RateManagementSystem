

import com.rms.demo.dto.RateDto;
import com.rms.demo.model.Rate;
import com.rms.demo.service.RateService;
import com.rms.demo.service.impl.RateServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class RateTest {

    RateDto rateDto;

    @Autowired
    RateService rateServiceImpl;
    @BeforeClass
    public static final void init() {
        ScriptRunner.initialise(RateTest.class);
    }
    /*
     * This test method is To save a new rate by giving all valid details .
     */
    @Test
    @Ignore
    public void saveRate() throws Exception {
        RateDto rateDto = new RateDto();
        rateDto.setRateEffectiveDate("02-Jan-2020");
        rateDto.setRateExpirationDate("02-Jan-2020");
        rateDto.setAmount(20000);
        rateDto.setRateDescription("amount");
        try {
            rateServiceImpl.saveRate(rateDto);
        } catch (Exception e) {
            Assert.fail("retrieveCustomerForMember failed !!!");
        }

    }

    /*
     * This test method is To get a rate by passing its id
     */
    @Test(expected = Exception.class)
    @Ignore
    public void getRate() throws Exception {
        Rate rate = null;
            try {
                rate = rateServiceImpl.findRateById(10000);
            } catch (Exception e) {
            Assert.fail("fetching failed !!!");
        }

    }

    /*
     * This test method is update an existing rate
     */
    @Test(expected = Exception.class)
    @Ignore
    public void updateRate() throws Exception {
        Rate rate = new Rate();
        rate = rateServiceImpl.findRateById(10000);
        rate.setRateEffectiveDate("02-Jan-2020");
        rate.setRateExpirationDate("02-Jan-2020");
        rate.setAmount(20000);
        rate.setRateDescription("amount");;
        try {
            rateServiceImpl.updateRate(10000, rateDto);
        } catch (Exception e) {
            Assert.fail("update failed !!!");
        }
    }

    /*
     * This test method is To get an existing product by giving a valid product Id.
     */
    @Test
    @Ignore
    public void deleteRate() throws Exception {
        try {
            rateService.deleteRateById(rateId);
        } catch (Exception e) {
            Assert.fail("deletion failed !!!");
        }
    }







}
