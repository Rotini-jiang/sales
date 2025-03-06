# Simplified Code Generation Strategy

## 1. Customer Code
- Format: `CYYxxxxx`
  - C: Fixed prefix 'C'
  - YY: Last 2 digits of year
  - xxxxx: 5-digit sequential number
- Examples:
  ```
  C2400001  // First customer in 2024
  C2400002  // Second customer in 2024
  C2400123  // 123rd customer in 2024
  ```

## 2. Product Code
- Format: `Pxxxxx`
  - P: Fixed prefix 'P'
  - xxxxx: 5-digit sequential number
- Examples:
  ```
  P00001  // First product
  P00002  // Second product
  P00123  // 123rd product
  ```

## 3. Order Number
- Format: `OYYMMxxxxx`
  - O: Fixed prefix 'O'
  - YY: Last 2 digits of year
  - MM: Month (01-12)
  - xxxxx: 5-digit sequential number
- Examples:
  ```
  O240100001  // First order in Jan 2024
  O240100002  // Second order in Jan 2024
  O240200001  // First order in Feb 2024
  ```

## Implementation
1. Use a simple database table to store counters:
```sql
CREATE TABLE counters (
    counter_type VARCHAR(10),  -- 'CUSTOMER', 'PRODUCT', 'ORDER'
    year INT,                  -- For customer and order
    month INT,                -- For order only
    current_value INT,
    PRIMARY KEY (counter_type, year, month)
);
```

2. When generating a new code:
   - Get and increment the counter
   - Format the code using the pattern
   - Validate uniqueness
   - Save the new code

3. Reset counters:
   - Customer: Yearly
   - Product: Never
   - Order: Monthly
