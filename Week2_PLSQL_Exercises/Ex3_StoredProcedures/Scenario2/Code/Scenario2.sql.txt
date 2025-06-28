SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN VARCHAR2,
  p_bonus_percent IN NUMBER
) AS
BEGIN
  -- Update salary by adding bonus percentage for employees in given department
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_percent / 100)
  WHERE Department = p_department;

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Salaries updated with a bonus of ' || p_bonus_percent || '% for department ' || p_department);
END;
/
BEGIN
  UpdateEmployeeBonus('IT', 10);
END;
/
