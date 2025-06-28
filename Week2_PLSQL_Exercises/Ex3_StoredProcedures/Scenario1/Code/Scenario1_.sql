CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  -- Update savings accounts by adding 1% interest to balance
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts.');
END;
/
BEGIN
  ProcessMonthlyInterest;
END;
/
