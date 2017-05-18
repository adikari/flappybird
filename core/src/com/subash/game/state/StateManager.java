package com.subash.game.state;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Manages the states of game
 */
public class StateManager {

  private Stack<State> states;

  public StateManager() {
    states = new Stack<State>();
  }

  /**
   * Get the states
   *
   * @return the states
   */
  public Stack<State> getStates() {
    return states;
  }

  /**
   * Add new state
   *
   * @param state State to add
   */
  public void push(State state) {
    states.push(state);
  }

  /**
   * Remove last state
   */
  public void pop() {
    states.pop();
  }

  /**
   * Remove last state and add new one on top
   *
   * @param state State to add
   */
  public void set(State state) {
    states.pop();
    states.push(state);
  }

  /**
   * Update the active state
   *
   * @param deltaTime Delta time
   */
  public void update(float deltaTime) {
    states.peek().update(deltaTime);
  }

  /**
   * Render the sprite batch on the active state
   *
   * @param sb Sprite batch to render
   */
  public void render(SpriteBatch sb) {
    states.peek().render(sb);
  }
}
