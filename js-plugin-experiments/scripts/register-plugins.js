// THIS FILE WILL NOT EXIST, IT WILL BE GENERATED BY 
// THE SERVER 

import {extensionPointStore, ExtensionPoint} from './blue-ocean';

import AlienLairLink from './plugins/AlienLairLink.jsx';
import AlienPageSubMenu from './plugins/AlienPageSubMenu.jsx';
import TopNavPipelineCounts from './plugins/TopNavPipelineCounts.jsx';
import MyPipelineRowExtension from './plugins/MyPipelineRowExtension.jsx';
import MyBadExtension from './plugins/MyBadExtension.jsx';
import FailureLogLink from './plugins/FailureLogLink.jsx'

extensionPointStore.addExtension("jenkins.pipeline.pipelineRow", MyBadExtension);
extensionPointStore.addExtension("jenkins.pipeline.pipelineRow", FailureLogLink);
extensionPointStore.addExtension("jenkins.pipeline.pipelineRow", MyPipelineRowExtension);
extensionPointStore.addExtension("jenkins.pipeline.alienPageHome", AlienPageSubMenu);
extensionPointStore.addExtension("jenkins.pipeline.alienPageSubMenu", AlienLairLink);
extensionPointStore.addExtension("jenkins.topNavigation.menu", TopNavPipelineCounts);