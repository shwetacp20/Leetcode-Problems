import pandas as pd

def total_time(employees: pd.DataFrame) -> pd.DataFrame:
    employees['total_time'] = employees['out_time'] - employees['in_time']
    
    df = employees.groupby(['emp_id', 'event_day'])['total_time'].sum().reset_index()
    df = df.rename(columns={'event_day': 'day'})
    return df[['day', 'emp_id', 'total_time']]