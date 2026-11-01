import pandas as pd

def replace_employee_id(employees: pd.DataFrame, employee_uni: pd.DataFrame) -> pd.DataFrame:
    merged_df = pd.merge(employees, employee_uni, on='id', how='left')
    result_df = merged_df[['unique_id', 'name']]
    
    return result_df