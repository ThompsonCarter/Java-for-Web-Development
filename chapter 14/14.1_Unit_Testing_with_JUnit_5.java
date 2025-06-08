
@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

  @Mock private TaxClient taxClient;

  @InjectMocks private PriceService priceService;

  @ParameterizedTest
  @CsvSource({"100,0.20,120", "50,0.10,55"})
  void shouldCalculateGross(BigDecimal net, BigDecimal tax, BigDecimal expected) {
    when(taxClient.getRate()).thenReturn(tax);
    assertEquals(expected, priceService.gross(net));
  }
}
    