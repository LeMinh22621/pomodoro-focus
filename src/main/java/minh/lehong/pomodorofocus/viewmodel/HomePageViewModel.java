package minh.lehong.pomodorofocus.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import minh.lehong.pomodorofocus.model.HomePageRepository;
public class HomePageViewModel {
    // properties
    private final IntegerProperty minuteProperty = new SimpleIntegerProperty(25);
    private final IntegerProperty secondProperty = new SimpleIntegerProperty(0);
    private final IntegerProperty currentSession = new SimpleIntegerProperty(1);
    private final BooleanProperty startClick = new SimpleBooleanProperty(false);
    // relatively
    /**
     * totalSession is the number which is present the session config
     */
    private final int totalSession = 4;
    private final int focusMinutes = 20;
    private final int shortBreakMinutes = 5;
    private final int longBreakMinutes = 15;
    /**
     * currentState is the current state of this session
     * 0: focus time
     * 1: short break
     * 2: long break
     */
    private int currentState = 0;
    // repository
    private final HomePageRepository homePageRepository;

    public HomePageViewModel(final HomePageRepository homePageRepository) {
        this.homePageRepository = homePageRepository;
    }

    public Integer getMinuteProperty() {
        return minuteProperty.get();
    }

    public IntegerProperty minutePropertyProperty() {
        return minuteProperty;
    }

    public void setMinuteProperty(Integer minuteProperty) {
        this.minuteProperty.set(minuteProperty);
    }

    public Integer getSecondProperty() {
        return secondProperty.get();
    }

    public IntegerProperty secondPropertyProperty() {
        return secondProperty;
    }

    public void setSecondProperty(Integer secondProperty) {
        this.secondProperty.set(secondProperty);
    }

    public Integer getCurrentSession() {
        return currentSession.get();
    }

    public IntegerProperty currentSessionProperty() {
        return currentSession;
    }

    public void setCurrentSession(Integer currentSession) {
        this.currentSession.set(currentSession);
    }

    public boolean isStartClick() {
        return startClick.get();
    }

    public BooleanProperty startClickProperty() {
        return startClick;
    }

    public void setStartClick(boolean startClick) {
        this.startClick.set(startClick);
    }

    public void startAction() {
        this.setStartClick(!this.isStartClick());
        Runnable runnable = () -> {
            while (this.isStartClick()) {
                // update seconds
                if (this.getSecondProperty() < 59 && this.getSecondProperty() >= 0) {
                    this.setSecondProperty(this.getSecondProperty() + 1);
                } else if (this.getSecondProperty() == 59) {
                    this.setSecondProperty(0);
                    switch (this.currentState) {
                        // update minutes
                        case 0 -> { // focus
                            if (this.getMinuteProperty() >= 0 && this.getMinuteProperty() < this.focusMinutes) {
                                this.setMinuteProperty(this.getMinuteProperty() + 1);
                            } else if (this.getMinuteProperty() == this.focusMinutes) {
                                // update currentState
                                this.currentState = 1;
                                this.setMinuteProperty(this.shortBreakMinutes);
                                this.setStartClick(false);
                            } else {
                                // wrong condition
                                System.out.println("wrong condition minutes -> focus");
                            }
                        }
                        case 1 -> { // short break
                            if (this.getMinuteProperty() >= 0 && this.getMinuteProperty() < this.shortBreakMinutes) {
                                this.setMinuteProperty(this.getMinuteProperty() + 1);
                            } else if (this.getMinuteProperty() == this.shortBreakMinutes) {
                                // update currentState
                                if (this.getCurrentSession() >= 1 && this.getCurrentSession() < this.totalSession) {
                                    this.currentState = 0;
                                    this.setCurrentSession(this.getCurrentSession() + 1);
                                    this.setMinuteProperty(this.focusMinutes);
                                    this.setStartClick(false);
                                } else if (this.getCurrentSession() == this.totalSession){
                                    this.currentState = 2;
                                    this.setMinuteProperty(this.longBreakMinutes);
                                    this.setStartClick(false);
                                }
                            } else {
                                // wrong condition
                                System.out.println("wrong condition minutes -> short break");
                            }
                        }
                        case 2 -> { // long break
                            if (this.getMinuteProperty() >= 0 && this.getMinuteProperty() < this.longBreakMinutes) {
                                this.setMinuteProperty(this.getMinuteProperty() + 1);
                            } else if (this.getMinuteProperty() == this.longBreakMinutes) {
                                // update currentState
                                this.setCurrentSession(1);
                                this.setMinuteProperty(this.focusMinutes);
                                this.setStartClick(false);
                            } else {
                                // wrong condition
                                System.out.println("wrong condition minutes -> short break");
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        };
        // update counter
        new Thread(runnable).start();
    }
}
