import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    unique_salaries = employee['salary'].drop_duplicates().sort_values(ascending=False)
    if N <= 0 or N > len(unique_salaries):
        return pd.DataFrame({f'getNthHighestSalary({N})': [None]})
    nth_salary = unique_salaries.iloc[N - 1]
    
    return pd.DataFrame({f'getNthHighestSalary({N})': [nth_salary]})