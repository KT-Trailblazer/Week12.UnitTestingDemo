import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {
  
  private TestDemo testDemo;

  @BeforeEach
  void setUp(){
    testDemo = new TestDemo();
  }

  static Stream<Arguments> argumentsForAddPositive() {
    
    return(Stream.of(arguments(1, 2, 3, false), arguments(2, 4, 6, false), 
                     arguments(2, -4, -2, true), arguments(-20, -5, -25, true), 
                     arguments(0, 0, 0, true), arguments(12, 3, 15, false), 
                     arguments(77, 37, 114, false), arguments(-11, 2, -9, true)));
  }
  
  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
    if(!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
    } else {
      assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
    }
  }
  
  //@Test
  //void assertThatNumberSquaredIsCorrect() {
  //  TestDemo mockDemo = spy(testDemo);
   // doReturn(5).when(mockDemo).getRandomInt();
   // int fiveSquared = mockDemo.randomNumberSquared();
  //  assertThat(fiveSquared).isEqualTo(25);
  //}
}