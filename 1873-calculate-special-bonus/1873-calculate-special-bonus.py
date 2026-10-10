import pandas as pd
import numpy as np
def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:
    is_odd=employees["employee_id"]%2!=0
    not_m=~employees["name"].str.startswith("M")
    employees["bonus"]=np.where(is_odd & not_m,employees["salary"],0)
    result=employees[["employee_id","bonus"]].sort_values("employee_id")
    return result