import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    
    authors=views[views["author_id"]==views["viewer_id"]]
    authors=authors[["author_id"]].drop_duplicates()
    authors=authors.rename(columns={"author_id":"id"})
    authors=authors.sort_values(by="id")
    return authors