package utils;

import java.io.File;

/** Class which contais different methods for validating user input */
public final class InputValidator {
  public static void validateAccountId(final String accountId) throws InvalidAccountIdException {
    if (!accountId.matches("^[0-9]+")) {
      throw new InvalidAccountIdException("AccountID can only contain numbers");
    }
  }

  public static void validateAccountFolder(final String accountId, final String configpath)
      throws InvalidAccountIdException, InvalidConfigPathException {

    validateAccountId(accountId);
    validateConfigPath(configpath);

    final File accountConfigFolder = new File(configpath, accountId);

    if (!accountConfigFolder.isDirectory()) {
      throw new InvalidAccountIdException(
          "Directory " + accountConfigFolder.getAbsolutePath() + " doesn't exist");
    }
  }

  public static void validateAccountFolder(final String accountId, final File configpath)
      throws InvalidAccountIdException, InvalidConfigPathException {

    validateAccountId(accountId);
    validateConfigPath(configpath);

    final File accountConfigFolder = new File(configpath, accountId);

    if (!accountConfigFolder.isDirectory()) {
      throw new InvalidAccountIdException(
          "Directory " + accountConfigFolder.getAbsolutePath() + " doesn't exist");
    }
  }

  public static void validateConfigPath(final String configPath) throws InvalidConfigPathException {
    final File userdata = new File(configPath);
    if (!userdata.isDirectory()) {
      throw new InvalidConfigPathException(
          "Directory " + userdata.getAbsolutePath() + " doesn't exist");
    }
  }

  public static void validateConfigPath(final File configPath) throws InvalidConfigPathException {
    final File userdata = configPath;
    if (!userdata.isDirectory()) {
      throw new InvalidConfigPathException(
          "Directory " + userdata.getAbsolutePath() + " doesn't exist");
    }
  }

  public static void validateGameId(final File accountPath, final String gameId)
      throws InvalidGameIdException {
    File gameDir = new File(accountPath, gameId);
    if (!gameDir.isDirectory()) {
      throw new InvalidGameIdException("Directory " + gameDir.getAbsolutePath() + " doesn't exist");
    }
  }
}
