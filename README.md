#jNavigation

Navigation for jMonkey Engine.

##Description
Members in this module are used to create mesh data that is then used to create Detour navigation meshes.

The are a large number of possible ways to building navigation mesh data. One of the simple piplines is as follows:
<ol>
Prepare the input triangle mesh.
<li>Build a rcHeightfield.</li>
<li>Build a rcCompactHeightfield.</li>
<li>Build a rcContourSet.</li>
<li>Build a rcPolyMesh.</li>
<li>Build a rcPolyMeshDetail.</li>
<li>Use the rcPolyMesh and rcPolyMeshDetail to build a Detour navigation mesh tile.</li>
</ol>
The general life-cycle of the main classes is as follows:
<ol>
<li>Allocate the object using the Recast allocator. (E.g. rcAllocHeightfield)</li>
<li>Initialize or build the object. (E.g. rcCreateHeightfield)</li>
<li>Update the object as needed. (E.g. rcRasterizeTriangles)</li>
<li>Use the object as part of the pipeline.</li>
<li>Free the object using the Recast allocator. (E.g. rcFreeHeightField)</li>
</ol>
###Note
This is a summary list of members. Use the index or search feature to find minor members.