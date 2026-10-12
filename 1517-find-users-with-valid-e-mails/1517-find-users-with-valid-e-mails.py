import pandas as pd

def valid_emails(users: pd.DataFrame) -> pd.DataFrame:
    pattern = '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\.com$'
    return users[users['mail'].str.contains(pattern, regex=True, na=False)]