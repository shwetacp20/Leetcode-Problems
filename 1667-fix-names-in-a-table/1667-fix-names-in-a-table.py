import pandas as pd

def fix_names(users: pd.DataFrame) -> pd.DataFrame:
    users["name"]=users["name"].str.slice(0,1).str.upper()+users["name"].str.slice(1).str.lower()
    return users.sort_values("user_id")