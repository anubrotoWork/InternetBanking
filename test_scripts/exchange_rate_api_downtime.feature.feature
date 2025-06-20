Feature: Exchange Rate API Downtime

  Scenario: User tries to access exchange rate during API downtime
    Given the API is down
    When the user opens the exchange rate display
    Then an error message should be displayed indicating that the exchange rate is currently unavailable due to API issues
