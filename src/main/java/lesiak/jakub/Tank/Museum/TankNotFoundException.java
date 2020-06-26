package lesiak.jakub.Tank.Museum;

class TankNotFoundException extends RuntimeException {

    TankNotFoundException(String name) {
        super("W bazie nie ma czołgu o nazwie" + name);
    }
}
