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
import EditView from '../lib/EditView';
import LoginButton from '../lib/LoginButton';
import LoginSuccess from '../ui/LoginSuccess';
import NetUtil from '../lib/NetUtil';
export default class LoginActivity extends Component {
  constructor(props) {
    super(props);
    this.userName = "";
    this.password = "";
  }

  render() {
      return (

    <View style={LoginStyles.loginview}>
     <View   style={{flexDirection: 'row',height:80,marginTop:1,
        justifyContent: 'center',
        alignItems: 'flex-start',}}>
       <Image source={require('../img/logo2.jpg')}/>
     </View>
     <View style={{marginTop:80}}>
       <EditView  name='请输入学号' onChangeText={(text) => {
            this.userName = text;
        }}/>
       <EditView name='请输入密码' onChangeText={(text) => {
            this.password = text;
        }}/>
        <LoginButton name='开始查询' onPressCallback={this.onPressCallback}/>
        <Text style={{color:"#4A90E2",textAlign:'center',marginTop:10}} >忘记密码？</Text>
      </View>
     </View>
   )
  }


  onPressCallback = () => {
    let formData = new FormData();
    formData.append("loginName",this.userName);
    formData.append("pwd",this.password);
//    let url = "http://localhost:8080/loginApp";
//    NetUtil.postJson(url,formData,(responseText) => {
//          alert(responseText);
//          this.onLoginSuccess();
      storeModule.search('***********','**********').then((map)=>{
          alert(map['user_id']);
        },(code,message)=>{
          alert(message);
          this.onLoginSuccess();
      })

    })

  };

  //跳转到第二个页面去
    onLoginSuccess(){
     const { navigator } = this.props;
     if (navigator) {
       navigator.push({
         name : 'ShowCJ',
         component : ShowCJ,
       });
     }
   }

}

class loginLineView extends Component {
  render() {
    return (
        <Text >
            没有帐号
          </Text>
    );
  }
}

const LoginStyles = StyleSheet.create({
  loginview: {
    flex: 1,
    padding: 30,
      backgroundColor: '#ffffff',
  },
});