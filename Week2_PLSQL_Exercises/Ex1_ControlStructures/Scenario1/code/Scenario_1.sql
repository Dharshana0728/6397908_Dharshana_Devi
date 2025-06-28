DECLARE
  v_age NUMBER;
BEGIN
  FOR rec IN (
    SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
  ) LOOP
    -- Calculate age
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

    IF v_age > 60 THEN
      -- Apply 1% discount
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = rec.LoanID;

      DBMS_OUTPUT.PUT_LINE('Loan '| rec.LoanID||':Interest rate discounted by 1% for customer '||rec.CustomerID||'(Age:'|| v_age ||')');
    END IF;
  END LOOP;

  COMMIT;
END;
/
