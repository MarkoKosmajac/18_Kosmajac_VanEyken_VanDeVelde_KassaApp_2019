package database;

import model.Artikel;

public interface Observer {
    void update(Artikel artikel);
}
