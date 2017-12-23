'use strict';
import React, { Component } from 'react';
import {
  ToolbarAndroid,
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Image,
  TextInput,
  TouchableOpacity
} from 'react-native';
import LoginActivity from './js/ui/main';
AppRegistry.registerComponent('FindPager', () => LoginActivity);
