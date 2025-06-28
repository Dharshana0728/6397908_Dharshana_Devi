SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) AS
  v_balance NUMBER;
BEGIN
  -- Check balance of source account
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
  ELSE
    -- Deduct from source
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;

    -- Add to destination
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transferred $' || p_amount || ' from account ' || p_from_account || ' to account ' || p_to_account);
  END IF;
END;
/
BEGIN
  TransferFunds(1, 2, 100);
END;
/
