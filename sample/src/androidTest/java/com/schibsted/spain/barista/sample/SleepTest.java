package com.schibsted.spain.barista.sample;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.schibsted.spain.barista.interaction.BaristaSleepInteractions;
import com.schibsted.spain.barista.sample.util.FailureHandlerValidatorRule;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SleepTest {

  @Rule
  public ActivityTestRule<FlowFirstScreen> activityRule = new ActivityTestRule<>(FlowFirstScreen.class);

  @Rule
  public FailureHandlerValidatorRule handlerValidator = new FailureHandlerValidatorRule();

  @Test
  public void sleepForASecondInMillis() {
    long start = System.currentTimeMillis();
    BaristaSleepInteractions.sleep(1000);
    long end = System.currentTimeMillis();

    long duration = end - start;

    assertTrue(duration > 1000);
    assertTrue(duration < 2000);
  }

  @Test
  public void sleepForASecondInTimeUnits() {
    long start = System.currentTimeMillis();
    BaristaSleepInteractions.sleep(1, TimeUnit.SECONDS);
    long end = System.currentTimeMillis();

    long duration = end - start;

    assertTrue(duration > 1000);
    assertTrue(duration < 2000);
  }
}
