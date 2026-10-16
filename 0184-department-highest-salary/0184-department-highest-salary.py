import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    if employee.empty or department.empty:
        return pd.DataFrame(columns=['Department', 'Employee', 'Salary'])

    merged = employee.merge(department, left_on='departmentId', right_on='id', suffixes=('_emp', '_dept'))
    max_salaries = merged.groupby('name_dept')['salary'].max().reset_index()
    result = merged.merge(max_salaries, on=['name_dept', 'salary'])
    
    final_df = result[['name_dept', 'name_emp', 'salary']].copy()
    final_df.columns = ['Department', 'Employee', 'Salary']
    
    return final_df