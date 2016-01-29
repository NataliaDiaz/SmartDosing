function _N(){}
function WN(){}
function O2(){}
function D4(){}
function bvb(){}
function avb(){}
function R6b(){}
function f7b(){}
function j7b(){}
function n7b(){}
function r7b(){}
function g7b(b){this.b=b}
function k7b(b){this.b=b}
function o7b(b){bb();this.b=b}
function d7b(b,c){b.enctype=c;b.encoding=c}
function LAb(b,c){b.onload=Doc(function(){c.Uf()})}
function E4(){var b;this.Lb=(b=$doc.createElement(xqc),b.type=Hqc,b)}
function s7b(b){var c;this.b=b;this.Lb=(c=$doc.createElement(xqc),c.type='file',c);this.Lb[iqc]='gwt-FileUpload'}
function S6b(b){if(b.p){$doc.body.removeChild(b.p);b.p.onload=null;b.p=null}}
function T6b(b){uCb(b.n,false);b.o||(b.e.Lb[sqc]=true,undefined);b.d=false}
function U6b(b){uCb(b.n,true);b.e.Lb[sqc]=false;b.d=true;if(b.o){S6b(b);b.o=false}}
function X6b(b,c){if(b.f!=c){b.f=c;if(b.f){Z$(b.e,1024);Z$(b.e,2048)}}J$(b.Lb,'v-upload-immediate',b.f)}
function W6b(b){z_(b.k,b.n);z_(b.k,b.e);b.e=new s7b(b);b.e.Lb.name=b.j+bzc;b.e.Lb[sqc]=!b.d;z3(b.k,b.e);z3(b.k,b.n);b.f&&Z$(b.e,1024)}
function bO(){ZN=new _N;Ub((Sb(),Rb),20);!!$stats&&$stats(xc(azc,Moc,-1,-1));ZN.Nc();!!$stats&&$stats(xc(azc,Nwc,-1,-1))}
function $N(){var b,c,d;while(XN){d=nb;XN=XN.b;!XN&&(YN=null);if(!d){(utb(),ttb).sg(bG,new bvb);Pkb()}else{try{(utb(),ttb).sg(bG,new bvb);Pkb()}catch(b){b=jJ(b);if(zr(b,37)){c=b;Qqb.De(c)}else throw b}}}}
function Y6b(b){if(b.e.Lb.value.length==0||b.o||!b.d){Qqb.Fe('Submit cancelled (disabled, no file or already submitted)');return}gib(b.b);b.c.submit();b.o=true;Qqb.Fe('Submitted form');T6b(b);b.q=new o7b(b);db(b.q,800)}
function V6b(b){var c;if(!b.p){c=$doc.createElement(Fqc);c.innerHTML="<iframe src=\"javascript:''\" name='"+b.j+"_TGT_FRAME' style='position:absolute;width:0;height:0;border:0'>"||Hoc;b.p=ie(c);$doc.body.appendChild(b.p);b.c.target=b.j+'_TGT_FRAME';LAb(b.p,b)}}
function Z6b(){this.Lb=$doc.createElement('form');this.e=new s7b(this);this.k=new C3;this.g=new E4;this.c=this.Lb;d7b(this.Lb,czc);this.c.method='post';M1(this,this.k);z3(this.k,this.g);z3(this.k,this.e);this.n=new xCb;Q$(this.n,new g7b(this),(Ck(),Ck(),Bk));z3(this.k,this.n);this.Lb[iqc]='v-upload';this.Ib==-1?xY(this.Lb,241|(this.Lb.__eventBits||0)):(this.Ib|=241)}
var bzc='_file',dzc='buttoncaption',azc='runCallbacks20';_=_N.prototype=WN.prototype=new J;_.gC=function aO(){return Vu};_.Nc=function eO(){$N()};_.cM={};_=O2.prototype=new n$;_.gC=function P2(){return ix};_.Sc=function Q2(b){U$(this,b)};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=E4.prototype=D4.prototype=new n$;_.gC=function F4(){return xx};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_=bvb.prototype=avb.prototype=new J;_.Qe=function cvb(){return new Z6b};_.gC=function dvb(){return XA};_.cM={137:1};_=Z6b.prototype=R6b.prototype=new J1;_.gC=function $6b(){return bG};_.jd=function _6b(){T$(this);!!this.b&&V6b(this)};_.Sc=function a7b(b){(xZ(b.type)&241)>0&&(xsb(this.b.J,b,this,null),undefined);U$(this,b)};_.kd=function b7b(){V$(this);this.o||S6b(this)};_.Uf=function c7b(){osb((Gc(),Fc),new k7b(this))};_.ce=function e7b(b,c){var d;if(oib(c,this,b,true)){return}if('notStarted' in b[1]){db(this.q,400);return}if('forceSubmit' in b[1]){Y6b(this);return}X6b(this,Boolean(b[1][Erc]));this.b=c;this.j=b[1][Bqc];this.i=b[1]['nextid'];d=lib(c,b[1][Hrc][ovc]);this.c.action=d;if(dzc in b[1]){wCb(this.n,b[1][dzc]);this.n.Lb.style.display=Hoc}else{this.n.Lb.style.display=gpc}this.e.Lb.name=this.j+bzc;if(sqc in b[1]||Crc in b[1]){T6b(this)}else if(!Boolean(b[1][Wrc])){U6b(this);V6b(this)}};_.cM={10:1,13:1,15:1,17:1,19:1,20:1,21:1,22:1,26:1,33:1,69:1,70:1,75:1,76:1};_.b=null;_.c=null;_.d=true;_.f=false;_.i=0;_.j=null;_.n=null;_.o=false;_.p=null;_.q=null;_=g7b.prototype=f7b.prototype=new J;_.gC=function h7b(){return ZF};_.ic=function i7b(b){this.b.f?(this.b.e.Lb.click(),undefined):Y6b(this.b)};_.cM={12:1,39:1};_.b=null;_=k7b.prototype=j7b.prototype=new J;_.Wb=function l7b(){if(this.b.o){if(this.b.b){!!this.b.q&&cb(this.b.q);Qqb.Fe('VUpload:Submit complete');gib(this.b.b)}W6b(this.b);this.b.o=false;U6b(this.b);this.b.Hb||S6b(this.b)}};_.gC=function m7b(){return $F};_.cM={3:1,14:1};_.b=null;_=o7b.prototype=n7b.prototype=new $;_.gC=function p7b(){return _F};_.Sb=function q7b(){Qqb.Fe('Visiting server to see if upload started event changed UI.');Fhb(this.b.b,this.b.j,'pollForStart',Hoc+this.b.i,true,105)};_.cM={65:1};_.b=null;_=s7b.prototype=r7b.prototype=new O2;_.gC=function t7b(){return aG};_.Sc=function u7b(b){U$(this,b);if(xZ(b.type)==1024){this.b.f&&this.b.e.Lb.value!=null&&!ogc(Hoc,this.b.e.Lb.value)&&Y6b(this.b)}else if(($lb(),!Zlb&&(Zlb=new vmb),$lb(),Zlb).b.i&&xZ(b.type)==2048){this.b.e.Lb.click();this.b.e.Lb.blur()}};_.cM={10:1,13:1,15:1,22:1,69:1,70:1};_.b=null;var Vu=Vec(ywc,'AsyncLoader20'),ix=Vec(Bwc,'FileUpload'),xx=Vec(Bwc,'Hidden'),XA=Vec(Iwc,'WidgetMapImpl$29$1'),ZF=Vec(Hwc,'VUpload$1'),$F=Vec(Hwc,'VUpload$2'),_F=Vec(Hwc,'VUpload$3'),aG=Vec(Hwc,'VUpload$MyFileUpload');Doc(bO)();